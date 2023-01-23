package com.example.recyclerviewwithviewtype1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter (
    private var products : ArrayList<Product>,
    private var users : ArrayList<User>
        ): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val VIEW_TYPE_PRODUCT =1
    val VIEW_TYPE_USER =2



            class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
                  var imgProduct: ImageView
                  var txtProductTitle: TextView
                  var txtProductPrice: TextView
                init {
                    imgProduct = itemView.findViewById(R.id.imgProduct)
                    txtProductTitle = itemView.findViewById(R.id.txtProductTitle)
                    txtProductPrice = itemView.findViewById(R.id.txtProductPrice)

                }
            }

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
         var imgUser: ImageView
         var UserName: TextView
         var UserId: TextView
        init {
            imgUser = itemView.findViewById(R.id.imgUser)
            UserName = itemView.findViewById(R.id.UserName)
            UserId = itemView.findViewById(R.id.UserId)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        var layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)

        if (viewType == VIEW_TYPE_PRODUCT){
            var productView: View = layoutInflater.inflate(R.layout.product_view,null)
            return ProductViewHolder(productView)
        }
        var userView = layoutInflater.inflate(R.layout.user_view,null)
        return UserViewHolder(userView)

    }

    override fun getItemViewType(position: Int): Int {
        if ((position+1)%5 == 0){
            return VIEW_TYPE_USER
        }
        return VIEW_TYPE_PRODUCT
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductViewHolder){
            var product = products[position-position/5]
            holder.txtProductTitle.text = product.title
            holder.txtProductPrice.text = "Rs.${product.price}"
        }
        if (holder is UserViewHolder){
            var userPosition = (position+1)/5-1
            if (userPosition >= users.size){
                userPosition = userPosition % 7
            }
            var user = users [userPosition]

            holder.UserName.text = user.name
            holder.UserId.text = user.Id


        }
    }

    override fun getItemCount(): Int {
        return products.size + users.size
    }
        }