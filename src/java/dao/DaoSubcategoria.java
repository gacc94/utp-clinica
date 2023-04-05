package dao;

import dto.Subcategoria;
import java.util.ArrayList;
import java.util.List;

public interface DaoSubcategoria {
    List<Subcategoria> subcategoriaSel();
    Subcategoria subcategoriaGet(int id);
    String subcategoriaIns(Subcategoria subcategoria);
    String subcategoriaUpd(Subcategoria subcategoria);
    String subcategoriaDel(List<Integer> ids);
    public ArrayList<Subcategoria> getNomSubCatxIdCat(int idcategoria);
    String getMensaje();

}
