package com.joncabdev.navigationtest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.joncabdev.navigationtest.R;
import com.joncabdev.navigationtest.db.entity.ProductosEntity;
import com.joncabdev.navigationtest.interfaces.ProductosInteractionListener;
import com.joncabdev.navigationtest.pojo.Productos;

import java.util.List;

// *** Si al adaptador se le quiere implementar se tiene que poner implements View.OnClickListener a la clase principal esto es despues de haber realziado el adaptador por completo
// 4ta se va a extender de RecyclerView.Adapter dentro de los simbolos se tiene que poner el ViewHolder que se creo en el primer paso
public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolder> {
    //5to Pide que implementemos los metodos y los implementa los cuales 3 onCreateViewHolder, onBindViewHolder, getItemCount

    //6to se implementa el context y la list
    Context context;
    // Lista estatica habilitar en casi de que no quede la nueva lista
//    List<Productos>productosList;
    //Se a cambiado algunas listas de Productos por ProductosEntity en all el adaptador y posiblemente en otros
    List<ProductosEntity> productosList;
    private ProductosInteractionListener productosInteractionListener;
    float cantidad;


    //7mo se crea el constructor


    public ProductosAdapter(Context context, List<ProductosEntity> productosList, ProductosInteractionListener productosInteractionListener) {
        this.context = context;
        this.productosList = productosList;
        this.productosInteractionListener = productosInteractionListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*8vo Se crea un View como el que esta aca abajo asi como el ViewHolder
         -En la parte de itemView se tiene que inlfar el xml de el cardView al que se le esta haciendo el adapter*/

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_productos_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //Se implementan las partes del cardview tal cual estan aqui

        String bla = String.valueOf(productosList.get(position).getCantidad());


        holder.mItem = productosList.get(position);
        holder.tvMarca.setText(productosList.get(position).getMarca());
        holder.tvTipo.setText(productosList.get(position).getTipo());
        //Cheacar aqui la cantidad
//        holder.tvContenido.setText(productosList.get(position).getCantidad());
        holder.tvContenido.setText(bla);
        holder.tvMedida.setText(productosList.get(position).getMedida());
        holder.tvDepartamento.setText(productosList.get(position).getDepartamento());

        //En esta parte se le da la instruccion de que si es favorito va a poner otro icono con la estrella con relleno
     /*   if (holder.mItem.isFavorito()) {
            holder.ivIconFavorita.setImageResource(R.drawable.ic_baseline_star_24);
        }*/

    }

    @Override
    public int getItemCount() {
        return productosList.size();
    }

    public void setNuevosProductos(List<ProductosEntity> nuevosProductos) {
        this.productosList = nuevosProductos;
        notifyDataSetChanged();
    }


    //1era Parte se crea una clase llamada ViewHolder que extiende de REcyclerView.ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        //Se implementan las partes que contiene el cardview
        public final TextView tvMarca, tvTipo, tvContenido, tvMedida, tvDepartamento;
        public final ImageView ivIconFavorita, ivEdit, ivDelete;
        //          Original
//        public Productos mItem;
        //nuevo
        public ProductosEntity mItem;

        // 2da Va a pedir implementar el public ViewHolder
        public ViewHolder(@NonNull View item) {
            super(item);

            //3ra Aqui se va a instanciar los objetos en las partes del cardview

            tvMarca = (TextView) item.findViewById(R.id.tvMarca);
            tvTipo = (TextView) item.findViewById(R.id.tvTipo);
            tvContenido = (TextView) item.findViewById(R.id.tvContenido);
            tvMedida = (TextView) item.findViewById(R.id.tvMedida);
            tvDepartamento = (TextView) item.findViewById(R.id.tvDepartamento);

            ivIconFavorita = (ImageView) item.findViewById(R.id.ivIconFavorito);
            ivEdit = (ImageView) item.findViewById(R.id.ivEdit);
            ivDelete = (ImageView) item.findViewById(R.id.ivDelete);





            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productosInteractionListener.onItemClick(getAdapterPosition());


                }
            });
            item.setOnLongClickListener((view) -> {

//                productosList.remove(getAdapterPosition());
//                notifyItemRemoved(getAdapterPosition());
                productosInteractionListener.onLongItemClcik(getAdapterPosition());

                return true;
            });

            ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productosInteractionListener.eliminarProducto(getAdapterPosition());
                }
            });

            ivEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productosInteractionListener.editProducto(getAdapterPosition());
                }
            });


        }


    }
}
