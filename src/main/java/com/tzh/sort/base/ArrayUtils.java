package com.tzh.sort.base;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 豪
 * @title: GenerateArray
 * @projectName interview
 * @description: TODO
 * @date 2019/6/6 13:00
 */
public class ArrayUtils {

    /**
     * 生成指定长度、指定最大值的随机int数组
     * @param size
     * @param numRange
     * @return
     */
    public static int[] generateArray(int size, int numRange) {
        return generateArray(size, numRange, true);
    }

    /**
     * 生成指定长度、指定最大值的随机int数组
     * @param size
     * @param numRange
     * @param hasNegative
     * @return
     */
    public static int[] generateArray(int size, int numRange, boolean hasNegative) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(numRange);
        }
        if (!hasNegative) {
            return array;
        }
        int negativeNum = (int) (size * 0.2);

        for (int i = 0; i < negativeNum; i++) {
            int index = random.nextInt(size);
            if (array[index] != 0) {
                array[index] = array[index] * -1;
            }
        }
        return array;
    }

    /**
     * 将随机数填入array中
     * @param array
     * @param numRange
     */
    public static void generateArray(int[] array, int numRange) {
        generateArray(array, numRange, true);
    }

    /**
     * 将随机数填入array中
     * @param array
     * @param numRange
     * @param hasNegative
     */
    public static void generateArray(int[] array, int numRange, boolean hasNegative) {
        Random random = new Random();
        int size = array.length;
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(numRange);
        }
        if (!hasNegative)
            return ;
        int negativeNum = (int) (size * 0.2);

        for (int i = 0; i < negativeNum; i++) {
            int index = random.nextInt(size);
            if (array[index] != 0) {
                array[index] = array[index] * -1;
            }
        }
    }

    /**
     * 测试排序20次平均用时
     * @param sortMethod
     * @return
     */
    public static double sortEffect(SortMethod sortMethod) {
        return sortEffect(20, 30000, sortMethod);
    }

    /**
     * 测试排序20次平均用时
     * @param hasNegative
     * @param sortMethod
     * @return
     */
    public static double sortEffect(boolean hasNegative, SortMethod sortMethod) {
        return sortEffect(20, 30000, hasNegative, sortMethod);
    }

    /**
     * 测试排序 testCount 次平均用时
     * @param testCount  测试次数
     * @param arrayLength
     * @param hasNegative
     * @param sortMethod
     * @return
     */
    public static double sortEffect(int testCount, int arrayLength, boolean hasNegative, SortMethod sortMethod) {

        List<Long> list = new ArrayList<>(testCount);
        int[] array = new int[arrayLength];
        for (int i = 0; i < testCount; i++) {
            generateArray(array, 999999, hasNegative);
            Instant start = Instant.now();
            sortMethod.test(array);
            Instant end = Instant.now();
            if (isOrder(array)) {
                list.add(Duration.between(start, end).toMillis());
            }
        }
        return list.stream().mapToLong(Long::longValue).average().orElse(-1);
    }

    /**
     * 测试排序 testCount 次平均用时
     * @param testCount 测试次数
     * @param sortMethod
     * @return
     */
    public static double sortEffect(int testCount, int arrayLength, SortMethod sortMethod) {

        return sortEffect(testCount, arrayLength, true, sortMethod);
    }

    /**
     * 测试排序方法是否有效
     * @param hasNagative
     * @param sortMethod
     * @return
     */
    public static boolean checkSort(boolean hasNagative, SortMethod sortMethod) {

        for (int i = 0; i < 20; i++) {
            int[] array = generateArray(200, 9999, hasNagative);
            sortMethod.test(array);
            if (!isOrder(array)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 测试排序方法是否有效
     * @param sortMethod
     * @return
     */
    public static boolean checkSort(SortMethod sortMethod) {
        return checkSort(true, sortMethod);
    }

    /**
     * 查看int数组是否有序
     * @param array
     * @return
     */
    public static boolean isOrder(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断数组的顺序
     * @param array
     * @return
     */
    public static String order(int[] array) {
        boolean flag = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return "升序";
        }
        flag = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return "降序";
        }

        return "无序";
    }

}
