package model;

public enum Categoria{
    ELETRONICOS(1, "Eletônicos"),
    ROUPAS(2, "Roupas"),
    ALIMENTOS(3, "Alimentos"),
    LIVROS(4, "Livros"),
    OUTROS(5, "Outros");

    private final int codigo;
    private final String descricao;

    Categoria(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getDescricao(){
        return descricao;
    }

    public static Categoria valueOf(int codigo){
        for(Categoria categoria : Categoria.values()){
            if(categoria.getCodigo() == codigo){
                return categoria;
            }
        }
        throw new IllegalArgumentException("Código inválido para a categoria!");
    }

    @Override
    public String toString(){
        return codigo + " - " + descricao;
    }

}