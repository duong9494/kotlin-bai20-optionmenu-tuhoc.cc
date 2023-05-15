package com.example.bai20_optionmenu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //đăng ký menu ngữ cảnh
        val txtContext = findViewById<TextView>(R.id.txtContext)
        registerForContextMenu(txtContext)
    }

    //khởi tạo menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(1, 1, 1, "Red")
        menu?.add(1, 2, 2, "Green")
        menu?.add(1, 3, 3, "black")

        //sub menu
        var subMenu = menu?.addSubMenu("Giới tính")
        subMenu?.add(2, 21, 1, "Male")?.setChecked(true)
        subMenu?.add(2, 22, 2, "Female")
        subMenu?.setGroupCheckable(2, true, true)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val txtOption = findViewById<TextView>(R.id.txtOption)
        val txtContext = findViewById<TextView>(R.id.txtContext)
        when(item.itemId){
            1->{txtOption.setTextColor(Color.RED)}
            2->{txtOption.setTextColor(Color.GREEN)}
            3->{txtOption.setTextColor(Color.BLACK)}
            // tương tác với submenu
            21->{txtOption.setText("Male")}
            22->{txtOption.setText("FeMale")}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(3, 31, 1, "Red")
        menu?.add(3, 32, 2, "Green")
        menu?.add(3, 33, 3, "Black")
        menu?.setHeaderTitle("Mời chụ chọn màu")
    }

    //xử lý sự kiện context menu
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val txtContext = findViewById<TextView>(R.id.txtContext)
        when(item.itemId) {
            31->{txtContext.setTextColor(Color.RED)}
            32->{txtContext.setTextColor(Color.GREEN)}
            33->{txtContext.setTextColor(Color.BLUE)}
        }
        return super.onContextItemSelected(item)
    }

}