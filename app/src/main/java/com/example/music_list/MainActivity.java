package com.example.music_list;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    //创建需要用到的控件的变量
    private TextView tv1,tv2;
    private FragmentManager fm;
    private FragmentTransaction ft;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//绑定控件
        tv1=(TextView)findViewById(R.id.menu1);
        tv2=(TextView)findViewById(R.id.menu2);
//设置监听器，固定写法
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
//若是继承 FragmentActivity，fm=getFragmentManger();
        fm=getSupportFragmentManager();
//fm 可以理解为 Fragment 显示的管理者，ft 就是它的改变者
        ft=fm.beginTransaction();
//默认情况下就显示 frag1
        ft.replace(R.id.content,new frag1());
//提交改变的内容
        ft.commit();
    }
    //控件的点击事件
    @Override
    public void onClick(View v){
        ft=fm.beginTransaction();
// 使用 if-else 语句来判断点击的是哪个选项卡
        if (v.getId() == R.id.menu1) {
            ft.replace(R.id.content,new frag1());
        } else if (v.getId() == R.id.menu2) {
            ft.replace(R.id.content,new frag2());
        }
        ft.commit();
    }
}