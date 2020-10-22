package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {
    public static String doGet(String httpurl) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// 返回结果字符串
        try {
            // 创建远程url连接对象
            URL url = new URL(httpurl);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                // 封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();// 关闭远程连接
        }

        return result;
    }

    public static String doPost(String httpUrl, String param) {

        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开连接
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接请求方式
            connection.setRequestMethod("POST");
            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);

            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);
            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
            connection.setRequestProperty("Content-Type", "application/json");
            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            connection.setRequestProperty("Authorization", "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiYXBwMDAxIiwiYm1zIl0sInVzZXJfbmFtZSI6Il9hZG1pbiIsInNjb3BlIjpbImFsbCJdLCJjb21wYW55Ijoi5Y2X5Lqs5Lia5oGS6L6-5pm66IO957O757uf6IKh5Lu95pyJ6ZmQ5YWs5Y-4IiwiZXhwIjoxNjAzMjg5OTUxLCJhdXRob3JpdGllcyI6WyJwbTpwcCIsIm1lbnUvYWRkIiwicG06dGRsIiwiZWNtOm9pbCIsImRhc2hib2FyZDp0YXNrIiwic3lzOmFjY291bnQiLCJwZXJzb25uZWw6Y2hlY2tJbiIsInBlcnNvbm5lbDpsZWF2ZSIsImNjbSIsInRlY2g6aGNjZm9ib2Z5bCIsImVjbSIsInRlY2g6UmF3Q29hbFVwRG93RXhwdDIiLCJ0ZWNoOmltdCIsInRlY2g6bXN0em0iLCJwYXJhbXRlci9wYWdpbmdRdWVyeSIsInBlcnNvbm5lbDpjbGFzc2VzIiwiY2NtOnZtIiwibWVudS9tb2RpZnkiLCJyb3V0aW5lIiwidGVjaDpzc3QiLCJ0YXNrOmRlbCIsInRlY2g6cGVtIiwiZGFzaGJvYXJkOnNoaXBwaW5nIiwiZGFzaGJvYXJkIiwic3lzOnJvbGUiLCJlcXB0IiwidGVjaDpSYXdDb2FsVXBEb3dFeHB0IiwiZWNtOmVsZWN0cmljIiwidGVjaCIsImVjbTp3YXRlciIsImNjbTpiYmkiLCJtZW51L2RlbCIsInRlY2g6Y3djIiwiZWNtOmRydWciLCJ0YXNrOmFkZCIsInRlY2g6aGNjZm9ib2YiLCJ0ZWNoOmZmdCIsInN5c3RlbSIsImVxcHQ6YmFzaWMiLCJzeXM6bWVudSIsIlJPTEVfQURNSU4iLCJlY206bWVkaWEiLCJwZXJzb25uZWwiLCJwbSIsInVzZXIiLCJjcW0iLCJkaWMiXSwianRpIjoiY2IzOWM0ZmQtNmNmYy00ODNkLWJiMmYtZmJiNzJiYTE5MmYwIiwiY2xpZW50X2lkIjoiYXBwMDAxIiwic3RhdHVzIjoib2siLCJjdXJyZW50QXV0aG9yaXR5IjpbIlJPTEVfQURNSU4iLCJjY20iLCJjY206YmJpIiwiY2NtOnZtIiwiY3FtIiwiZGFzaGJvYXJkIiwiZGFzaGJvYXJkOnNoaXBwaW5nIiwiZGFzaGJvYXJkOnRhc2siLCJkaWMiLCJlY20iLCJlY206ZHJ1ZyIsImVjbTplbGVjdHJpYyIsImVjbTptZWRpYSIsImVjbTpvaWwiLCJlY206d2F0ZXIiLCJlcXB0IiwiZXFwdDpiYXNpYyIsIm1lbnUvYWRkIiwibWVudS9kZWwiLCJtZW51L21vZGlmeSIsInBhcmFtdGVyL3BhZ2luZ1F1ZXJ5IiwicGVyc29ubmVsIiwicGVyc29ubmVsOmNoZWNrSW4iLCJwZXJzb25uZWw6Y2xhc3NlcyIsInBlcnNvbm5lbDpsZWF2ZSIsInBtIiwicG06cHAiLCJwbTp0ZGwiLCJyb3V0aW5lIiwic3lzOmFjY291bnQiLCJzeXM6bWVudSIsInN5czpyb2xlIiwic3lzdGVtIiwidGFzazphZGQiLCJ0YXNrOmRlbCIsInRlY2giLCJ0ZWNoOlJhd0NvYWxVcERvd0V4cHQiLCJ0ZWNoOlJhd0NvYWxVcERvd0V4cHQyIiwidGVjaDpjd2MiLCJ0ZWNoOmZmdCIsInRlY2g6aGNjZm9ib2YiLCJ0ZWNoOmhjY2ZvYm9meWwiLCJ0ZWNoOmltdCIsInRlY2g6bXN0em0iLCJ0ZWNoOnBlbSIsInRlY2g6c3N0IiwidXNlciJdfQ.CePHuxUSEN6Z-MkNxJL2DFq8WVmPqNIokNHl7oXvaPQ");
            // 通过连接对象获取一个输出流
            os = connection.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            os.write(param.getBytes());
            // 通过连接对象获取一个输入流，向远程读取
            if (connection.getResponseCode() == 200) {

                is = connection.getInputStream();
                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // 循环遍历一行一行读取数据
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 断开与远程地址url的连接
            connection.disconnect();
        }
        return result;
    }

    public static void main(String[] args) {
        String message = doPost("http://10.10.10.75:9092/bms/menu/getMenuByUser","");
        System.out.println(message);
    }

}
