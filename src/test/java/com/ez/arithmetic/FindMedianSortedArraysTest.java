package com.ez.arithmetic;

import com.alibaba.fastjson.JSON;
import com.ez.arithmetic.leetcode.IFindMedianSortedArrays;
import com.ez.arithmetic.leetcode.impl.FindMedianSortedArrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindMedianSortedArraysTest {
    IFindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
    List<TestCase> testCaseList = new ArrayList<>();

    @Before
    public void before() {
        int[] a1 = {1, 2}, a2 = {3, 5};
        float rs = 2.5f;
        TestCase testCase = new TestCase(a1, a2, rs);
        testCaseList.add(testCase);
        int[] a3 = {1, 2}, a4 = {3, 4, 5};
        rs = 3;
        testCase = new TestCase(a3, a4, rs);
        testCaseList.add(testCase);
    }

    /**
     * 解法1：通过合并两个苏数组方式合并
     */
    @Test
    public void solutionMidByMerge() {
        for (TestCase testCase : testCaseList) {
            testCase.setResult(findMedianSortedArrays.solutionMidByMerge(testCase.getA1(), testCase.getA2()));
            Assert.assertEquals(testCase.toString(), testCase.getExpect(), testCase.getResult(), 0);
        }
    }

    /**
     * 解法2：通过求两个数组总第K大数（最优解）
     */
    @Test
    public void solutionMidByTopK() {
        for (TestCase testCase : testCaseList) {
            testCase.setResult(findMedianSortedArrays.solutionMidByTopK(testCase.getA1(), testCase.getA2()));
            Assert.assertEquals(testCase.toString(), testCase.getExpect(), testCase.getResult(), 0);
        }
    }

    /**
     * 解法3：常规解法
     */
    @Test
    public void solutionMitByDivide() {
        for (TestCase testCase : testCaseList) {
            testCase.setResult(findMedianSortedArrays.solutionMidNormal(testCase.getA1(), testCase.getA2()));
            Assert.assertEquals(testCase.toString(), testCase.getExpect(), testCase.getResult(), 0);
        }
    }

    class TestCase {
        public TestCase(int[] a1, int[] a2, float expect) {
            this.a1 = a1;
            this.a2 = a2;
            this.expect = expect;
        }

        private int[] a1 = null;
        private int[] a2 = null;
        private float expect = 0;
        private float result = 0;

        public int[] getA1() {
            return a1;
        }

        public void setA1(int[] a1) {
            this.a1 = a1;
        }

        public int[] getA2() {
            return a2;
        }

        public void setA2(int[] a2) {
            this.a2 = a2;
        }

        public float getExpect() {
            return expect;
        }

        public void setExpect(float expect) {
            this.expect = expect;
        }

        public float getResult() {
            return result;
        }

        public void setResult(float result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }
}
