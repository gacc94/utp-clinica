package dao;

import dto.Categoria;
import java.util.ArrayList;
import java.util.List;

public interface DaoCategoria {
    List<Categoria> categoriaSel();
    List<Categoria> getListCatxId(int cat);
    Categoria categoriaGet(int id);
    String categoriaIns(Categoria categoria);
    String categoriaUpd(Categoria categoria);
    String categoriaDel(List<Integer> ids);
    String getMensaje();
}
