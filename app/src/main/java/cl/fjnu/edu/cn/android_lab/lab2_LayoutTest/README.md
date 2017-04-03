# Android lab2_LayoutTest
## 程序主界面
 这是程序的入口，点击三个按钮可分别跳转至三个布局实验。
![程序主界面](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab2_LayoutTest/images/mainActivity.png)
## 线性布局实验
 这个布局，是在外层的垂直线性布局里面嵌套了四个水平线性布局，每个水平布局分别放置了四个TextView实现的。至于TextView的边框，则是在drawable下定义一个边框形状的XML文件，然后通过设置TextView的background属性来实现。
![线性布局实验](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab2_LayoutTest/images/linearLayout.png)
## 相对布局实验
 这个布局，是在相对布局里面设置每个Button之间的相对位置来实现的。
![相对布局实验](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab2_LayoutTest/images/relativeLayout.png)
## 表格布局实验
 这个布局，是在垂直表格布局里面嵌套三个表格布局实现的。每个嵌套的表格布局里面，每一行都是一个TableRow，有多少行就有多少个TableRow。嵌套的表格布局之间的分割线则是通过view并设置其高度和颜色来实现的。
![表格布局实验](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab2_LayoutTest/images/tableLayout.png)
