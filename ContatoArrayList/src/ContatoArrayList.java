import java.util.ArrayList;

public class ContatoArrayList {
    private String nome;
    private String telefone;
    private String email;

    public ContatoArrayList(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email;
    }
}

class ListaContatos {
    private ArrayList<ContatoArrayList> contatos;

    public ListaContatos() {
        contatos = new ArrayList<>();
    }

    // 1. Adicionar elemento ao final da lista
    public void adicionarContato(ContatoArrayList contato) {
        contatos.add(contato);
    }

    // 2. Verificar a quantidade de elementos da lista
    public int quantidadeContatos() {
        return contatos.size();
    }

    // 3. Imprimir elementos da lista
    public void imprimirContatos() {
        for (ContatoArrayList contato : contatos) {
            System.out.println(contato);
        }
    }

    // 4. Obter elemento de uma posição da lista
    public ContatoArrayList obterContato(int index) {
        if (index >= 0 && index < contatos.size()) {
            return contatos.get(index);
        }
        return null;
    }

    // 5. Verificar se elemento existe na lista
    public boolean existeContato(ContatoArrayList contato) {
        return contatos.contains(contato);
    }

    // 6. Adicionar elemento em qualquer posição da lista
    public void adicionarContato(int index, ContatoArrayList contato) {
        if (index >= 0 && index <= contatos.size()) {
            contatos.add(index, contato);
        }
    }

    // 7. Remover elemento da lista
    public void removerContato(ContatoArrayList contato) {
        contatos.remove(contato);
    }

    // 8. Pesquisa por nome
    public ContatoArrayList pesquisarPorNome(String nome) {
        for (ContatoArrayList contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    // 9. Pesquisa por e-mail
    public ContatoArrayList pesquisarPorEmail(String email) {
        for (ContatoArrayList contato : contatos) {
            if (contato.getEmail().equalsIgnoreCase(email)) {
                return contato;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListaContatos lista = new ListaContatos();
        ContatoArrayList contato1 = new ContatoArrayList("João", "123456789", "joao@example.com");
        ContatoArrayList contato2 = new ContatoArrayList("Maria", "987654321", "maria@example.com");

        lista.adicionarContato(contato1);
        lista.adicionarContato(contato2);

        System.out.println("Quantidade de contatos: " + lista.quantidadeContatos());
        lista.imprimirContatos();

        ContatoArrayList contatoObtido = lista.obterContato(1);
        System.out.println("Contato na posição 1: " + contatoObtido);

        System.out.println("Contato existe: " + lista.existeContato(contato1));

        ContatoArrayList contato3 = new ContatoArrayList("Pedro", "555555555", "pedro@example.com");
        lista.adicionarContato(1, contato3);
        lista.imprimirContatos();


        lista.removerContato(contato1);
        lista.imprimirContatos();

        // Teste de pesquisa por nome
        ContatoArrayList contatoPesquisadoPorNome = lista.pesquisarPorNome("Maria");
        System.out.println("Contato pesquisado por nome 'Maria': " + contatoPesquisadoPorNome);

        // Teste de pesquisa por e-mail
        ContatoArrayList contatoPesquisadoPorEmail = lista.pesquisarPorEmail("pedro@example.com");
        System.out.println("Contato pesquisado por e-mail 'pedro@example.com': " + contatoPesquisadoPorEmail);
    }
}