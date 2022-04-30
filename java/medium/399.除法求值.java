import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 */

// @lc code=start
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        UnionFind uf = new UnionFind(n * 2);
        // 将a，b，c，d映射为数字，方便并查集运算
        Map<String, Integer> map = new HashMap<>( n * 2);
        int id = 0;
        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);
            if (!map.containsKey(var1)) {
                map.put(var1, id++);
            }
            if (!map.containsKey(var2)) {
                map.put(var2, id++);
            }
            uf.union(map.get(var1), map.get(var2), values[i]);            
        }

        int querySize = queries.size();
        double[] result = new double[querySize];
        for (int i = 0; i < querySize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);
            if (id1 == null || id2 == null) { //UF中不存在
                result[i] = -1.0d;
            } else {
                result[i] = uf.getWeight(id1, id2);
            }
        }
        return result;       
    }

    class UnionFind {
        /**
         * a / b = 2.0
         * parent[a] = b
         * weight[a] = 2.0
         */
        private int[] parent;
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            // 指向父节点的权值
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // 初始状态指向自己
                weight[i] = 1.0d;
            }
        }

        /**
         * 路径压缩的find,将x节点及其parents全部指向根
         * @param x
         * @return
         */
        public int find(int x) {
            if (parent[x] != x) {
                int origin = parent[x]; // 缓存父节点
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin]; // 父节点权值*自身权值
            }
            return parent[x];
        }

        /**
         * 返回节点的根节点,不含路径压缩
         * @param x
         * @return
         */
        public int find1(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }

        /**
         * 递归写法
         * @param x
         * @return
         */
        public int find2(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                return find2(parent[x]);
            }
        }

        /**
         * 
         * @param x
         * @param y
         * @param value: x->y的权值
         */
        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            // X指向Y
            parent[rootX] = rootY;
            // 更新X的权值
            weight[rootX] = weight[y] * value / weight[x];
        }

        private void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            // p指向q（反向亦可）
            parent[rootP] = rootQ;
        }

        /**
         * p / q = (p/root) / (q/root)
         * @param p
         * @param q
         * @return
         */
        public double getWeight(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return weight[p] / weight[q];
            } else {
                return -1.0d;
            }
        }

        private boolean isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
    }
}
// @lc code=end

