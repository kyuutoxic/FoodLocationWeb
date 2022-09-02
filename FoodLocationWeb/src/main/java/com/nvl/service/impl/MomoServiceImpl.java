/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service.impl;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.nvl.pojo.Cart;
import com.nvl.service.MomoService;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 *
 * @author Copeoshihi
 */
@Service
public class MomoServiceImpl implements MomoService {

    @Override
    public JSONObject payment(long total, Map<Integer, Cart> cart) {
        Random rand = new Random();
        float requestID=rand.nextFloat();
        float orderID=rand.nextFloat();
        String endpoint = "https://test-payment.momo.vn/v2/gateway/api/create";
        String partnerCode = "MOMOBKUN20180529";
        String accessKey = "klm05TvNBzhg7h7j";
        String secretKey = "at67qH6mk8w5Y1nAyMoYKMWACiEi2bsa";
        String orderInfo = "Pay the order";
        String redirectUrl = "http://localhost:8080/FoodLocationWeb/returnmomo";
        String ipnUrl = "http://localhost:8080/FoodLocationWeb/notimomo";
        String amount = String.valueOf(total);
        String orderId = String.valueOf(orderID);
        String requestId = String.valueOf(requestID);
        String requestType = "captureWallet";
        String extraData = "";
        String rawSignature = "accessKey=" + accessKey + "&amount=" + amount + "&extraData=" + extraData + "&ipnUrl=" + ipnUrl + "&orderId=" + orderId + "&orderInfo=" + orderInfo + "&partnerCode=" + partnerCode + "&redirectUrl=" + redirectUrl + "&requestId=" + requestId + "&requestType=" + requestType;
        Mac hasher;
        String signature = null;
        try {
            byte[] signa = null;
            hasher = Mac.getInstance("HmacSHA256");
            hasher.init(new SecretKeySpec(secretKey.getBytes(), "HmacSHA256"));
            signa = hasher.doFinal(rawSignature.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(signa.length * 2);
            Formatter formatter = new Formatter(sb);
            for (byte b : signa) {
                formatter.format("%02x", b);
            }
            signature = sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MomoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(MomoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSONObject data = new JSONObject();
        data.put("partnerCode", partnerCode);
        data.put("partnerName", "Test");
        data.put("storeId", "MomoTestStore");
        data.put("requestId", requestId);
        data.put("amount", amount);
        data.put("orderId", orderId);
        data.put("orderInfo", orderInfo);
        data.put("redirectUrl", redirectUrl);
        data.put("ipnUrl", ipnUrl);
        data.put("lang", "vi");
        data.put("extraData", extraData);
        data.put("requestType", requestType);
        data.put("signature", signature);
        for (Cart c : cart.values()) {
            JSONObject item = new JSONObject();
            item.put("id", c.getMenuId());
            item.put("name", c.getMenuName());
            item.put("imageUrl", c.getImage());
            item.put("price", c.getPrice());
            item.put("quantity", c.getQuantity());
            item.put("totalPrice", c.getPrice() + c.getQuantity());
            data.append("items", item);
        }
        String clen = String.valueOf(data.length());
        System.out.println("HIHIHIHIHI"+data);
        try {
            URL url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Content-Length", clen);
            con.setDoOutput(true);
            try ( OutputStream os = con.getOutputStream()) {
                byte[] input = data.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try ( BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                String responseLine = null;
                StringBuilder response = new StringBuilder();
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                JSONObject res = new JSONObject(response.toString());
                res.put("signature", signature);
                con.disconnect();         
                return res;
            }
        } catch (ProtocolException ex) {
            Logger.getLogger(MomoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MomoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MomoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
