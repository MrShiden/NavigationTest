package com.joncabdev.navigationtest.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.joncabdev.navigationtest.R;
import com.joncabdev.navigationtest.adapters.ProductosAdapter;
import com.joncabdev.navigationtest.clases.ConexionSQLiteHelper;
import com.joncabdev.navigationtest.interfaces.ComunicationInterface;
import com.joncabdev.navigationtest.interfaces.ProductosInteractionListener;
import com.joncabdev.navigationtest.pojo.Productos;

import java.util.ArrayList;
import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;


public class ProductosFragment extends Fragment implements ProductosInteractionListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    RecyclerView recyclerLista;
    ImageView ivFavorita;
    Activity actividad;

    List<Productos> productosList;
    ProductosAdapter adapter;



    ComunicationInterface productosInterFace;


    public ProductosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaCompraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductosFragment newInstance(String param1, String param2) {
        ProductosFragment fragment = new ProductosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Conexion a base de datos
        //TODO 51. Como crear una Base de Datos SQLite en Android seguir con este
        ConexionSQLiteHelper conexcion = new ConexionSQLiteHelper(getContext(), "BD_Productos", null, 1);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_productos, container, false);


        productosList = new ArrayList<>();
        recyclerLista = view.findViewById(R.id.recyclerview_fragment_productos);


        recyclerLista.setLayoutManager(new LinearLayoutManager(getContext()));


        cargardatos();
        menuSelected(view);



        adapter = new ProductosAdapter(getContext(), productosList, this);
        productosList.get(4);
        recyclerLista.setAdapter(adapter);


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerLista);




        // Inflate the layout for this fragment
        return view;
    }

    private void menuSelected(View view) {


        //FAB: Accion del boton FAB que manda a la activity para crear productos en la base de datos
        view.findViewById(R.id.fabProductos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productosInterFace.gotoCreateProducto();

               /* NavHostFragment.findNavController(ProductosFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);*/

              /*  Snackbar.make(recyclerLista, "La prueba", Snackbar.LENGTH_LONG)
                        .setAction("Nada", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getContext(), "Nada", Toast.LENGTH_SHORT).show();
                            }
                        }).show();*/
            }
        });
    }

    //Ver mas detalles en la lista de reproduccion de youtube del mustafa

    Productos productoRemovido = null;

    // Se le puede implementar ItemTouchHelper.RIGHT para que tenga la accion de deplazarse a la derecha
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            int position = viewHolder.getAdapterPosition();

            switch (direction) {
                case ItemTouchHelper.LEFT:

                    productoRemovido = productosList.get(position);
                    productosList.remove(position);
                    adapter.notifyItemRemoved(position);
                    Snackbar.make(recyclerLista, "Producto eliminado", Snackbar.LENGTH_LONG)
                            .setAction("Deshacer", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    productosList.add(position, productoRemovido);
                                    adapter.notifyItemInserted(position);
                                }
                            }).show();


                    break;


                //En caso de que se dezplace a la derecha aqui se implementa la accion requerida.
               /* case ItemTouchHelper.RIGHT:

                    break;*/
            }

        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(getContext(), R.color.design_default_color_error))
                    .addSwipeLeftActionIcon(R.drawable.ic_baseline_delete_24)
                    .create()
                    .decorate();


            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };


    private void cargardatos() {

        productosList.add(new Productos("1", "Frutas", "25", "kg", false, "Farmacia"));
        productosList.add(new Productos("2", "Huevos", "25.4", "Kg", true, "Abarrotes"));
        productosList.add(new Productos("3", "Frutas", "25", "kg", false, "Farmacia"));
        productosList.add(new Productos("4", "Frutas", "25", "kg", false, "Farmacia"));
        productosList.add(new Productos("5", "Frutas", "25", "kg", false, "Farmacia"));
        productosList.add(new Productos("6", "Frutas", "25", "kg", false, "Farmacia"));
        productosList.add(new Productos("7", "Frutas", "25", "kg", false, "Farmacia"));
        productosList.add(new Productos("8", "Frutas", "25", "kg", false, "Farmacia"));
        productosList.add(new Productos("9", "Frutas", "25", "kg", false, "Farmacia"));


    }


    @Override
    public void editProducto(int position) {
        Toast.makeText(getContext(), productosList.get(position).toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void eliminarProducto(int position) {
        productosList.remove(position);
        adapter.notifyItemRemoved(position);

    }

    @Override
    public void favoritaProducto(int position) {

    }

    @Override
    public void onItemClick(int position) {


    }

    @Override
    public void onLongItemClcik(int position) {

      /*  productosList.remove(position);
        adapter.notifyItemRemoved(position);
*/

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            actividad = (Activity) context;
            productosInterFace = (ComunicationInterface) actividad;
        }
    }


}


