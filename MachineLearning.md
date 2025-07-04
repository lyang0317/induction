# 提纲

### 发展历程
  * 机器学习 -> 神经网络 -> 符号学习/统计学习 -> 决策树/支持向量机 -> 深度学习


### 评估模型
  * 误差率和精度
  * 查全率与查准率，PR图
  * 真正率 假正律 真负率 假负率，ROC图 AUC面积，损失函数
  * 代价敏感函数


### 线性回归
  * 线性回归
    * 最小二乘法
    * 矩阵求导
  * 广义线性模型，需要连续，否则梯度下降法无法应用
  * 对率函数
    * 凸优化
    * 矩阵求导
  * 线性判别分析（LDA）
    * 均值向量/协方差矩阵
    * 朗格朗日乘子法
  * 多分类学习（区别于多标记）
    * OvO OvR 拆分策略
    * MvM ECOC纠错输出码
  * 类别不平衡问题
    * 再缩放 y'/ (1 - y')= y / (1 - y) * (m- / m+)


### 决策树
  * 选择最优划分属性 纯度
    * ID3 信息增益
    * C4.5 增益率
    * Cart决策树 基尼指数
  * 剪枝
    * 预剪枝
    * 后剪枝
  * 连续值处理
    * C4.5 二分法划分点t Gain(D, A) = max (t ∈ Ta) Gain(D, a, t)
  * 缺失值处理
    * C4.5 ρ pk‘ rv’
  * 多变量决策树 结合图 轴平行 协划分


### 神经网络
  * 单层感知机
  * 多层感知机
    * BP算法，加入隐含层，梯度下降求导
  * 全局最小和局部最小问题
  * 深度学习
    * 预训练 + 微调
    * 卷积神经网络，特征学习

### 支持向量机(SVM 找最优超平面)

# 定理
  * 没有免费的午餐