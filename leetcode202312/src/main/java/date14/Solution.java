package date14;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Solution {
    //    2960. 统计已测试设备
    public int countTestedDevices(int[] batteryPercentages) {
        int sum = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] > 0) {
                sum++;
                batteryPercentages = count1(i + 1, batteryPercentages);
            }
        }
        return sum;
    }

    private int[] count1(int index, int[] batteryPercentages) {
        if (index == batteryPercentages.length) {
            return batteryPercentages;
        }
        for (int i = index; i < batteryPercentages.length; i++) {
            batteryPercentages[i] = batteryPercentages[i] - 1;
        }
        return batteryPercentages;
    }

    //    2962. 统计最大元素出现至少 K 次的子数组
    public long countSubarrays(int[] nums, int k) {
        long count=0;
//        获取最大值
        int max=Integer.MIN_VALUE;
        for (int num : nums) {
            if(num>max){
                max=num;
            }
        }
//        滑动窗口来解决
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <nums.length; j++) {
                if(count(i,j,nums,max)>=k){
                    count++;
                }
            }
        }
        return count;
    }

    public int count(int i,int j,int[] nums,int max){
        int count=0;
        for (int k = i; k <= j; k++) {
            if(nums[k]==max){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://timor.tech/api/holiday/year/2024");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        try {
            String holiday = JSONObject.parseObject(EntityUtils.toString(response.getEntity())).getString("holiday");
            System.out.println(holiday);

        } finally {
            response.close();
        }
    }
}
