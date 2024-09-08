package login;
import java.util.HashMap;
import java.util.Map;

public class Cadastro {
    // Chave é o id do usuário
    private Map<Integer, User> contas;

    public Cadastro() {
        this.contas = new HashMap<>();
    }

    // Verifica se existe um usuário
    public boolean verificaOcorrencia(int id) {
        return contas.containsKey(id);
    }

    public boolean validaCadastro(User user) {
        if (verificaOcorrencia(user.getId())) {
            System.out.println("Usuário já cadastrado!");
            return false;
        }
        contas.put(user.getId(), user);  // Adiciona o usuário no array usando o id
        System.out.println("Usuário cadastrado com sucesso!");
        return true;
    }

    public boolean alteraSenha(int id, String novaSenha) {
        User user = contas.get(id);
        if (user != null) {
            user.setSenha(novaSenha);
            System.out.println("Senha alterada com sucesso!");
            return true;
        } else {
            System.out.println("Usuário não encontrado!");
            return false;
        }
    }
    public void listarContas() {
        System.out.println("Contas cadastradas:");
        for (User user : contas.values()) {
            System.out.println("ID: " + user.getId() + ", Nome: " + user.getNome());
        }
    }
}


