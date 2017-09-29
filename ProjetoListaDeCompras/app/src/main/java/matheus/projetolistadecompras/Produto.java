package matheus.projetolistadecompras;

import java.util.ArrayList;

public class Produto {
    private Integer quantidade;
    private String nome;
    private boolean perecivel;
    private String categoria;

    public Produto(Main2Activity listaProdutosActivity, int simple_list_item_checked, ArrayList<Produto> produtos) {
    }

    public Produto(int quantidade, String nome, boolean perecivel, String categoria) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.perecivel = perecivel;
        this.categoria = categoria;
    }

    public Integer getQuantidade() {

        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPerecivel() {
        return perecivel;
    }

    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
