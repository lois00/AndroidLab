# Android lab3_UITest
## 程序主界面
这是程序的入口，点击四个按钮可分别跳转至四个UI实验。
![mainActivity](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab3_UITest/images/mainActivity.png)

## 1.实验一：利用SimpleAdapter实现ListView页面布局效果
这个实验，是给ListView设置了一个SimpleAdapter适配器，用来给ListView下的每个listItem设置布局格式、文本内容以及图像资源等。同时给这个ListView设置了监听器，当用户单击某个listItem时，触发该监听器，实现弹出一个Toast消息的效果。为了个性化显示Toast消息，编写了一个ToastUtil工具类和toast_shape布局文件，用来控制Toast的弹出位置以及外观显示等。
实验结果如下：
![simpleAdapter](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab3_UITest/images/simpleAdapter.png)

## 2.实验二：创建自定义布局的AlertDialog
这个实验，是实现当点击主界面上的“自定义AlertDialog”按钮时，在当前界面上以浮窗的形式弹出一个自定义的登录对话框，对话框提供用户名、密码输入和登录、取消选项。同时对话框的标题可个性定制，可包含图像等。
实验结果如下：
![alertDialog](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab3_UITest/images/alertDialog.png)

## 3.实验三：使用XML定义菜单
这个实验，是通过使用XML文件，来自定义选项菜单的内容与格式，实现对输入文本的字体大小控制、字体颜色改变，以及其他提示性操作。
3.1 选项菜单列表：
![menuXML1](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab3_UITest/images/menuXML1.png)
3.2 改变输入文本的字体大小效果展示：
![menuXML2](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab3_UITest/images/menuXML2.png)
3.3 弹出Toast提示信息效果展示：
![menuXML3](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab3_UITest/images/menuXML3.png)
3.4 改变输入文本的字体颜色效果展示：
![menuXML4](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab3_UITest/images/menuXML4.png)

## 4.实验四：创建ActionMode的上下文菜单
这个实验，实现的是当用户采用长按ListView的某个ListItem时，调出ActionMode形式的上下文菜单，并实现对ListItem的多选、全选、删除等功能。ListView的适配器是一个继承了SimpleAdaper的自定义适配器，这个适配器用来对每个ListItem的内容显示、选择状态、被选中个数统计、删除等的控制。为了实现多选，还自定义了一个实现MultiChoiceModeListener接口的多选监听器类，用来监听ListItem的单击和状态改变事件，同时控制ActionMode菜单中的已选中项的文本显示。
4.1 显示列表：
![ctxMenuActionMode1](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab3_UITest/images/ctxMenuActionMode1.png)
4.2 全选列表：
![ctxMenuActionMode2](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab3_UITest/images/ctxMenuActionMode2.png)
4.3 多选列表：
![ctxMenuActionMode3](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab3_UITest/images/ctxMenuActionMode3.png)
4.4 删除列表：
![ctxMenuActionMode4](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab3_UITest/images/ctxMenuActionMode4.png)
