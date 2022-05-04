package com.example.pizzadelivery


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dapter.Horizontal2Adapter
import com.example.dapter.HorizontalAdapter
import com.example.dapter.VerticalAdapter
import com.example.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecycler1View: RecyclerView
    private lateinit var newRecycler2View: RecyclerView
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<PizzaItemV>
    private lateinit var newArrayItemList: ArrayList<PizzaItemH2>
    private lateinit var newArrayMyList: ArrayList<PizzaItemH>
    private lateinit var navController: NavController
    lateinit var titleImage: Array<Int>
    lateinit var titleText: Array<String>
    lateinit var description: Array<String>
    lateinit var price: Array<String>
    lateinit var imageTitle: Array<Int>
    lateinit var textTitle: Array<String>
    lateinit var info: Array<String>
    lateinit var infoText: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleImage = arrayOf(
            R.drawable.ariva,
            R.drawable.chickcheese,
            R.drawable.diablo,
            R.drawable.hammursh,
            R.drawable.hawaii,
            R.drawable.mix,
            R.drawable.peperoni,
            R.drawable.vegmursh,
            R.drawable.chocolate_milkshake,
            R.drawable.classic_milk_shake,
            R.drawable.milk_shakecweets_oreo,
            R.drawable.strawberry_milkshake,
            R.drawable.coffee_americano,
            R.drawable.coffee_capuchino,
            R.drawable.coffee_latte,
            R.drawable.cacao_with_marshmelo,
            R.drawable.raspberry_punsh,
            R.drawable.cherry_pie,
            R.drawable.brusletics
        )

        titleText = arrayOf(
            "Аррива",
            "Сырный цыпленок",
            "Диабло",
            "Ветчина и грибы",
            "Гавайская",
            "Микс",
            "Пепперони",
            "Ветчина и грибы",
            "Шоколадный молочный \nкоктейль",
            "Классический молочный \nкоктейль ",
            "Молочный коктейль с \nпеченьем Орео",
            "Клубничный молочный \nкоктейль",
            "Кофе Американо",
            "Кофе Капучино",
            "Кофе Латте",
            "Какао с маршмеллоу",
            "Малиновый пунш",
            "Вишневый пирог",
            "Бруслетики, 16 шт"
        )
        description = arrayOf(
            "Цыпленок, острая чоризо,\nсоус бургер, сладкий перец,\nкрасный лук, томаты, моцарелла, \nсоус, ранч, чеснок",
            "Цыпленок, моцарелла, сыры \nчеддер и пармезан, сырный соус, томаты, соус альфредо, чеснок",
            "Острая чоризо, острый перец \nхалапеньо, соус барбекю, \nмитболы, томаты, сладкий перец, \nкрасный лук, моцарелла, \nтоматный соус",
            "Ветчина, шампиньоны, \nувеличенная порция моцареллы,\nтоматный соус",
            "Ветчина, ананасы, моцарелла, \nтоматный соус",
            "Это классическая итальянская \nпицца, начинка в которой \nсостоит из четырех сортов сыра. \nБекон, цыпленок, ветчина, сыр \nблю чиз, сыры чеддер и \nпармезан, соус песто, кубики \nбрынзы, томаты, красный лук, \nмоцарелла, соус альфредо, чеснок, итальянские травы",
            "Пикантная пепперони, \nувеличенная порция моцареллы, томатный соус",
            "Ветчина, шампиньоны, \nувеличенная порция моцареллы, \nтоматный соус",
            "Шоколадный молочный коктейль \nсо сливочным мороженым и \nфирменным какао",
            "Молочный напиток с мороженым",
            "Молочный коктейль с мороженым \nи дробленым печеньем «Орео»",
            "Коктейль с клубничным сиропом",
            "Пара глотков горячего Американо, \nи вы будете готовы покорять этот \nдень",
            "Король среди кофейных напитков — \nклассический капучино. Для \nлюбителей сбалансированного \nкофейно-молочного вкуса",
            "Когда хочется нежную молочную \nпенку, на помощь приходит \nклассический латте",
            "Горячий какао с молоком, нежная \nмолочная пенка и ванильный \nмаршмеллоу",
            "Согревающий напиток на основе \nпюре малины и черной смородины",
            "Это не просто десерт, а вишенка на торте! \nТворожно-песочное тесто с \nягодами, заварным кремом и лепестками миндаля.",
            "Это задорные сладкие рулетики, \nв которых закрутился микс из \n натуральной брусники и \nсгущенного молока."
        )
        price = arrayOf(
            "354 ₽", "687 ₽", "695 ₽", "460 ₽", "350 ₽",
            "945 ₽", "945 ₽", "750 ₽", "120 ₽", "130 ₽",
            "110 ₽", "200 ₽", "165 ₽", "230 ₽", "320 ₽",
            "400 ₽", "250 ₽", "160 ₽", "350 ₽"
        )
        imageTitle = arrayOf(
            R.drawable.banner1, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4,
            R.drawable.banner5, R.drawable.banner6, R.drawable.banner7
        )
        textTitle = arrayOf(
            "Пицца", "Десерты", "Напитки", "Акции", "Контакты"
        )

        info = arrayOf(
            getString(R.string.info_a),
            getString(R.string.info_b),
            getString(R.string.info_c),
            getString(R.string.info_d),
            getString(R.string.info_e),
            getString(R.string.info_f),
            getString(R.string.info_g),
            getString(R.string.info_h),
            getString(R.string.info_i),
            getString(R.string.info_j),
            getString(R.string.info_k),
            getString(R.string.info_l),
            getString(R.string.info_m),
            getString(R.string.info_n),
            getString(R.string.info_o),
            getString(R.string.info_p),
            getString(R.string.info_q),
            getString(R.string.info_r),
            getString(R.string.info_s)

        )
        infoText= arrayOf(
            getString(R.string.infoText_a),
            getString(R.string.infoText_b),
            getString(R.string.infoText_c),
            getString(R.string.infoText_d),
            getString(R.string.infoText_e),
            getString(R.string.infoText_f),
            getString(R.string.infoText_g),
            getString(R.string.infoText_h),
            getString(R.string.infoText_i),
            getString(R.string.infoText_j),
            getString(R.string.infoText_k),
            getString(R.string.infoText_l),
            getString(R.string.infoText_m),
            getString(R.string.infoText_n),
            getString(R.string.infoText_o),
            getString(R.string.infoText_p),
            getString(R.string.infoText_q),
            getString(R.string.infoText_r),
            getString(R.string.infoText_s)
        )

//Horizontal
        newRecycler1View = findViewById(R.id.imagehorizontal)
        newRecycler1View.setHasFixedSize(true)
        newArrayMyList = arrayListOf<PizzaItemH>()
        getUsdata()
//Horizontal
        newRecycler2View = findViewById(R.id.texthorizontal)
        newRecycler2View.setHasFixedSize(true)
        newArrayItemList = arrayListOf<PizzaItemH2>()
        getUdata()

//Vertical
        newRecyclerView = findViewById(R.id.vertical)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<PizzaItemV>()
        getUserdata()
    }

//Horizontal RecyclerView

    private fun getUsdata() {
        for (a in imageTitle.indices) {
            val list = PizzaItemH(imageTitle[a])
            newArrayMyList.add(list)
        val adapter = HorizontalAdapter(newArrayMyList)
        newRecycler1View.adapter = adapter
        adapter.setOnItemClickListener(object : HorizontalAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, InfoFragment::class.java)
                intent.putExtra("imageTitle", newArrayMyList[position].imageTitle)
                startActivity(intent)
            }
        })
    }
}
//Horizontal RecyclerView

    private fun getUdata() {
        for (c in textTitle.indices) {
            val list = PizzaItemH2(textTitle[c])
            newArrayItemList.add(list)
        val adapter = Horizontal2Adapter(newArrayItemList)
        newRecycler2View.adapter = adapter
        adapter.setOnItemClickListener(object : Horizontal2Adapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, InfoFragment::class.java)
                intent.putExtra("imageTitle", newArrayMyList[position].imageTitle)
                startActivity(intent)

            }

        })
    }
}

//Vertical RecyclerView

    private fun getUserdata() {
        for (i in titleImage.indices) {
            val list = PizzaItemV(titleImage[i], titleText[i], description[i], price[i])
            newArrayList.add(list)
            val adapter = VerticalAdapter(newArrayList)
            newRecyclerView.adapter = adapter
            adapter.setOnItemClickListener(object : VerticalAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {
//                    Toast.makeText(this@MainActivity,"You clicked on item no.$position", Toast.LENGTH_SHORT).show()
                    val fragmentManager: FragmentManager = supportFragmentManager
                    val fragmentTransaction: FragmentTransaction =fragmentManager.beginTransaction()
                    val bundle = Bundle()
                    val myFragment = InfoFragment()
                    bundle.putInt("titleImage", newArrayList[position].titleImage)
                    bundle.putString("titleText", newArrayList[position].titleText)
                    bundle.putString("info", info[position])
                    bundle.putString("infoText", infoText[position])
                    myFragment.arguments = bundle
                    fragmentTransaction.add(R.id.container, myFragment).addToBackStack(null).commit()
                    newRecyclerView.addItemDecoration(DividerItemDecoration(newRecyclerView.context, LinearLayoutManager.VERTICAL))
                }

            })
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        //Создание Фрагмент меню
        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()
        val basketFragment = BasketFragment()
        val menuFragment = MenuFragment()

        val contactFragment = ContactFragment()
        val enterFragment = EnterFragment()
        val aboutUsFragment = AboutUsFragment()
        val basket2Fragment = Basket2Fragment()

        setCurrentFragment(homeFragment)

        val btn = findViewById<BottomNavigationView>(R.id.bNav)
        btn.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homemenu -> {
                    setCurrentFragment(homeFragment)
                    Toast.makeText(this, "Дома", Toast.LENGTH_SHORT).show()
                }
                R.id.profilemenu -> {
                    setCurrentFragment(profileFragment)
                    Toast.makeText(this, "Профиль", Toast.LENGTH_SHORT).show()
                }

                R.id.basketmenu -> {
                    setCurrentFragment(basketFragment)
                    Toast.makeText(this, "Корзина", Toast.LENGTH_SHORT).show()
                }

                R.id.menumenu -> {
                    setCurrentFragment(menuFragment)
                    Toast.makeText(this, "Меню", Toast.LENGTH_SHORT).show()
                }

                R.id.aboutUsFragment -> setCurrentFragment(aboutUsFragment)
                R.id.basket2Fragment -> setCurrentFragment(basket2Fragment)
                R.id.enterFragmemt -> setCurrentFragment(enterFragment)
                R.id.contactFragment -> setCurrentFragment(contactFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
}
