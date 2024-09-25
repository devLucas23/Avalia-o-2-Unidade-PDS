package Questão1;

// Classe abstrata para o Sanduíche, ela declara quais os atributos e como eles serão impressos
abstract class Sanduiche {
    protected String pao;
    protected String queijo;
    protected String presunto;
    protected boolean salada;

    @Override
    public String toString() {
        return "Sanduíche com Pão: " + pao + ",\nQueijo: " + queijo + ",\nPresunto: " + presunto + ",\nSalada: " + (salada ? "Com verdura" : "Sem verdura");
    }
}

// Classe concreta para o Sanduíche, chamo de sanduicheBasico pois ela será o template para os sanduiches da fábrica
//Chama-se assim pois ele serve de template básico para os sanduíches das fábricas, se necessário, as fabricas podem
//modificar como precisarem.
class SanduicheBasico extends Sanduiche {
    public SanduicheBasico() {
        this.pao = "Pão Integral";
        this.queijo = "Queijo Prato";
        this.presunto = "Presunto de Frango"; 
        this.salada = true;
    }
}

// Interface para a Fábrica de Sanduíches (Factory), veja que ela só declara as funções.
abstract class SanduicheFactory {
    public abstract Sanduiche criarSanduiche();
}

// Fábrica concreta para a Lanchonete CG
// Veja que ela dá override na função de criarSanduiche.
// Já que o sanduiche básico é o da CG, não precisamos modificar ele, apenas retornar
class LanchoneteCG extends SanduicheFactory {
    @Override
    public Sanduiche criarSanduiche() {
        return new SanduicheBasico();
    }
}

// Fábricas concretas para a Lanchonete JP e para a Lanchonete RT
//Veja que os sanduiches são modificados para as outras factories
class LanchoneteJP extends SanduicheFactory {
    @Override
    public Sanduiche criarSanduiche() {
        Sanduiche sanduiche = new SanduicheBasico();
        sanduiche.pao = "Pão Francês";
        sanduiche.queijo = "Queijo Mussarela";
        sanduiche.presunto = "Presunto de Frango";
        sanduiche.salada = true;
        return sanduiche;
    }
}

class LanchoneteRT extends SanduicheFactory {
    @Override
    public Sanduiche criarSanduiche() {
        Sanduiche sanduiche = new SanduicheBasico();
        sanduiche.pao = "Pão Bola";
        sanduiche.queijo = "Queijo Cheddar";
        sanduiche.presunto = "Presunto de Peru";
        sanduiche.salada = false;
        return sanduiche;
    }
}

public class Main {
    public static void main(String[] args) {
        
        // Criando os sanduíches
        //aqui, podemos ver o toString que modificamos sendo usado para imprimir as caracteristicas dos sandubas
        SanduicheFactory lanchoneteCG = new LanchoneteCG();
        Sanduiche sanduicheCG = lanchoneteCG.criarSanduiche();
        System.out.println("Lanchonete CG: \n" + sanduicheCG); 
        System.out.println("\n\n");

        SanduicheFactory lanchoneteJP = new LanchoneteJP();
        Sanduiche sanduicheJP = lanchoneteJP.criarSanduiche();
        System.out.println("Lanchonete JP: \n" + sanduicheJP);
        System.out.println("\n\n");

        SanduicheFactory lanchoneteRT = new LanchoneteRT();
        Sanduiche sanduicheRT = lanchoneteRT.criarSanduiche();
        System.out.println("Lanchonete RT: \n" + sanduicheRT);
        System.out.println("\n\n");
    }
}
