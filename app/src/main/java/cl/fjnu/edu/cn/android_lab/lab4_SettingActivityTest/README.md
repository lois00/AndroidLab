# Android lab4_SettingActivityTest
## **In-line preferences**<br>
 一个简单的checkbox，用户可以自主勾选.<br>
![Checkbox preferences](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab4_SettingActivityTest/images/lab4_1.png)<br>
## **Dialog-based preferences**<br>
**Edit text preference**<br>
 点击Edit text preference选项，打开一个编辑框，用户可以输入内容.<br>
![Edit text preference](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab4_SettingActivityTest/images/lab4_2.png)<br>
**List preference**<br>
 点击List preference选项，弹出一个列表，提供三个选项供用户选择.<br>
![List preference](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab4_SettingActivityTest/images/lab4_3.png)<br>
## **Launch preferences**<br>
**Screen preference**<br>
 点击Screen preference选项，跳转到另一个PreferenceScreen.<br>
![Screen preference](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab4_SettingActivityTest/images/lab4_4.png)<br>
**Intent preference**<br>
 点击Intent preference选项，打开系统浏览器，跳转至百度主页.<br>
![Intent preference](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab4_SettingActivityTest/images/lab4_5.png)<br>
## **Preference attributes**<br>
 当Parent checkbox未被勾选时，Child checkbox将会隐藏且无法勾选。只有Parent checkbox被勾选了，Child checkbox才会显示出来并且可勾选。Child checkbox的可选状态依赖于Parent checkbox.<br>
**Parent checkbox preference**<br>
![Parent checkbox preference](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab4_SettingActivityTest/images/lab4_6_1.png)<br>
**Child checkbox preference**<br>
![Child checkbox preference](https://github.com/lois00/AndroidLab/blob/master/app/src/main/java/cl/fjnu/edu/cn/android_lab/lab4_SettingActivityTest/images/lab4_6_2.png)<br>
