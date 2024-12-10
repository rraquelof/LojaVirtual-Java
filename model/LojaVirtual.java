package model;
import java.util.*;

public class LojaVirtual {
    private Map<Integer, Produto> produtos = new HashMap<>();
    private List<Produto> carrinho = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    public void adicionarProduto(){
        System.out.print("ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();

        System.out.println("Categoria do produto:");
        for(Categoria categoria : Categoria.values()){
            System.out.println(categoria);
        }
        System.out.println("Informe o número da categoria: ");
        int numCategoria = scanner.nextInt();
        Categoria categoria;
        try{
            categoria = Categoria.valueOf(numCategoria);
        }catch (IllegalArgumentException e){
             System.out.println("Categoria inválida! Tente novamente!");
             return;
        }
        produtos.put(id, new Produto(id, nome, preco, categoria));
        System.out.println("Produto Cadastrado com sucesso!");
    }

    public void exibirProdutosCadastrados(){
        if(produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado!");
        }else{
            System.out.println("Produtos Cadastrados:");
            produtos.forEach((id, produto) -> System.out.println(id + " - " + produto));
        }
    }

    public void adicionarAoCarrinho(){
        System.out.print("Digite o ID do item que deseja adicionar ao carrinho: ");
        int id = scanner.nextInt();
        if (produtos.containsKey(id)){
            // carrinho.add(produtos.get(id))
            Produto produto = produtos.get(id);
            carrinho.add(produto);
            System.out.println("Item adicionado ao carrinho!");
        }else{
            System.out.println("Produto não encontrado!");
        }
    }

    public void removerDoCarrinho(){
        System.out.print("Digite o ID do item que deseja remover do carrinho: ");
        int id = scanner.nextInt();
        for (Produto produto : carrinho){
            if (produto.getId() == id){
                carrinho.remove(produto);
                System.out.println("Item removido do carrinho!");
                return;
            }else{
                
            }
        }
    }

    public void exibirCarrinho(){
        if(carrinho.isEmpty()){
            System.out.println("O carrinho está vazio!");
        }else{
            System.out.println("Produtos do carrinho:");
            carrinho.forEach(System.out::println);
        }
    }

    public void aplicarDesconto(){
        System.out.print("Digite o percentual de desconto (0-100): ");
        double desconto = scanner.nextDouble();
        for(Produto produto : carrinho){
            produto.setPreco(produto.getPreco() - produto.getPreco() * (desconto/100));
        }
        System.out.println("Desconto aplicado com sucesso!");
    }

    public void totalCompra(){
        double total = 0;
        for(Produto produto : carrinho){
            total += produto.getPreco();
        }
        System.out.println("Preço total: R$ "+ total);
    }

    public void exibirMenu(){
        int opcao;
        do{
            System.out.println("Menu Loja Virtual:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Adicionar ao Carrinho");
            System.out.println("3. Remover do Carrinho");
            System.out.println("4. Exibir Carrinho");
            System.out.println("5. Aplicar Desconto");
            System.out.println("6. Total da Compra");
            System.out.println("7. Produtos cadastrados");
            System.out.println("8. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> adicionarProduto();
                case 2 -> adicionarAoCarrinho();
                case 3 -> removerDoCarrinho();
                case 4 -> exibirCarrinho();
                case 5 -> aplicarDesconto();
                case 6 -> totalCompra();
                case 7 -> exibirProdutosCadastrados();
                case 8 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        }while(opcao!=8);
    }
}