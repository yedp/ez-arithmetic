package com.ez.arithmetic;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 见：soruce/picture/8-queens.png
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 示例:
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *  
 * 提示：
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。（引用自 百度百科 - 皇后 ）
 */
public class NQueens {

    public static void main(String args[]) {
        Solution solution = new Solution();
        List<List<String>> rs = solution.solveNQueens(5);

        System.out.println(rs);
    }

    static class Solution {
        //某行、撇、捺数据已在皇后攻击范围
        private boolean[] colomns, pie, na;
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            colomns = new boolean[n];
            pie = new boolean[2 * n];
            na = new boolean[2 * n];//相减原本存储【-n，n】的值，index不能小于0，因此区间+n放到【0，2n】
            solveNQueens(n, 0, new ArrayList<Integer>());
            return convertToStr(res);
        }


        public List<List<String>> convertToStr(List<List<Integer>> res) {
            List<List<String>> matrixLists = new ArrayList<List<String>>();
            for (List<Integer> list : res) {
                List<String> matrixList = new ArrayList<>();
                for (Integer num : list) {
                    StringBuffer buffer = new StringBuffer();
                    for (Integer i = 0; i < list.size(); i++) {
                        if (num.equals(i)) {
                            buffer.append("Q");
                        } else {
                            buffer.append(".");
                        }
                    }
                    matrixList.add(buffer.toString());
                }
                matrixLists.add(matrixList);
            }
            return matrixLists;
        }

        /**
         * @param n   几个皇后
         * @param row 第几行
         * @param pos 皇后位置：【index，pos】
         */
        public void solveNQueens(Integer n, Integer row, List<Integer> pos) {
            //超出查询行返回
            if (row >= n) {
                res.add(new ArrayList<>(pos));
                return;
            }
            //循环找每个可以放的位置
            for (int colomn = 0; colomn < n; colomn++) {
                if (colomns[colomn] || pie[row + colomn] || na[row - colomn + n]) {
                    continue;
                }
                colomns[colomn] = true;
                pie[row + colomn] = true;
                na[row - colomn + n] = true;
                pos.add(colomn);
                solveNQueens(n, row + 1, pos);
                colomns[colomn] = false;
                pie[row + colomn] = false;
                na[row - colomn + n] = false;
                pos.remove(pos.size() - 1);
            }

        }

    }
}
