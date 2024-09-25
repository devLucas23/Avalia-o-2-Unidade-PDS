package Questão2;

//No abstract factory, os itens usados pelas fábrica também tem interfaces abstratas que serão modificadas
//Ou seja, mini fábricas de ingredientes!

// Nas interfaces para os ingredientes, declaramos apenas os gets dos tipos,
//depois iremos definir quais são pra cada fábrica de pão, queijo, presunto e salada
interface PaoIF {
    String getTipoPao(); 
}                       
interface QueijoIF {
    String getTipoQueijo();
}
interface PresuntoIF {
    String getTipoPresunto();
}
interface SaladaIF {
    boolean temSalada();
}

// Interface da fábrica de ingredientes
// Veja que usamos os abstratos na criação dessa interface
interface SanduichesIngredientFactory { 
    PaoIF criarPao();
    QueijoIF criarQueijo();
    PresuntoIF criarPresunto();
    SaladaIF criarSalada();
}

// Implementação concreta dos ingredientes
// Pode ver que usamos override nos gets para retornar os tipos certos em cada classe

//Pães
class PaoIntegral implements PaoIF { 
    @Override
    public String getTipoPao() {
        return "Pão Integral";
    }
}

class PaoFrances implements PaoIF {
    @Override
    public String getTipoPao() {
        return "Pão Francês";
    }
}

class PaoBola implements PaoIF {
    @Override
    public String getTipoPao() {
        return "Pão Bola";
    }
}

//Queijos
class QueijoPrato implements QueijoIF {
    @Override
    public String getTipoQueijo() {
        return "Queijo Prato";
    }
}

class QueijoMussarela implements QueijoIF {
    @Override
    public String getTipoQueijo() {
        return "Queijo Mussarela";
    }
}

class QueijoCheddar implements QueijoIF {
    @Override
    public String getTipoQueijo() {
        return "Queijo Cheddar";
    }
}

//Presuntos
class PresuntoFrango implements PresuntoIF {
    @Override
    public String getTipoPresunto() {
        return "Presunto de Frango";
    }
}

class PresuntoPeru implements PresuntoIF {
    @Override
    public String getTipoPresunto() {
        return "Presunto de Peru";
    }
}

//Com ou sem salada?
class SemSalada implements SaladaIF {
    @Override
    public boolean temSalada() {
        return false;
    }
}

class ComSalada implements SaladaIF {
    @Override
    public boolean temSalada() {
        return true;
    }
}

// Implementações concretas das fábricas de sanduíches
//Aqui temos as fábricas de cada lanchonete, herdando a fabrica abstrata e dando override nas funções de criação
//dos ingredientes. Então, cada uma pega seu tipo correto de infrediente para fazer seu sanduba!
class SanduichesIngredientFactoryCG implements SanduichesIngredientFactory {
    @Override
    public PaoIF criarPao() {
        return new PaoIntegral();
    }

    @Override
    public QueijoIF criarQueijo() {
        return new QueijoPrato();
    }

    @Override
    public PresuntoIF criarPresunto() {
        return new PresuntoFrango();
    }

    @Override
    public SaladaIF criarSalada() {
        return new SemSalada();
    }
}

class SanduichesIngredientFactoryJP implements SanduichesIngredientFactory {
    @Override
    public PaoIF criarPao() {
        return new PaoFrances();
    }

    @Override
    public QueijoIF criarQueijo() {
        return new QueijoMussarela();
    }

    @Override
    public PresuntoIF criarPresunto() {
        return new PresuntoFrango();
    }

    @Override
    public SaladaIF criarSalada() {
        return new ComSalada();
    }
}

class SanduichesIngredientFactoryRT implements SanduichesIngredientFactory {
    @Override
    public PaoIF criarPao() {
        return new PaoBola();
    }

    @Override
    public QueijoIF criarQueijo() {
        return new QueijoCheddar();
    }

    @Override
    public PresuntoIF criarPresunto() {
        return new PresuntoPeru();
    }

    @Override
    public SaladaIF criarSalada() {
        return new SemSalada();
    }
}

// Classe Sanduíche que usa a fábrica de ingredientes
// No caso, o retorno de cada fábrica vai ser usado aqui, pra imprimir o sanduba usando o toString
class Sanduiche {
    private PaoIF pao;
    private QueijoIF queijo;
    private PresuntoIF presunto;
    private SaladaIF salada;

    public Sanduiche(SanduichesIngredientFactory factory) {
        this.pao = factory.criarPao();
        this.queijo = factory.criarQueijo();
        this.presunto = factory.criarPresunto();
        this.salada = factory.criarSalada();
    }

    @Override
    public String toString() {
        return "Sanduíche com Pão: " + pao.getTipoPao() + ",\nQueijo: " + queijo.getTipoQueijo() +
                ",\nPresunto: " + presunto.getTipoPresunto() + ",\nSalada: " + (salada.temSalada() ? "Com verdura" : "Sem verdura");
    }
}

public class Main {
    public static void main(String[] args) {
        SanduichesIngredientFactory factoryCG = new SanduichesIngredientFactoryCG();
        Sanduiche sanduicheCG = new Sanduiche(factoryCG);
        System.out.println("Lanchonete CG: \n" + sanduicheCG);
        System.out.println("\n\n");

        SanduichesIngredientFactory factoryJP = new SanduichesIngredientFactoryJP();
        Sanduiche sanduicheJP = new Sanduiche(factoryJP);
        System.out.println("Lanchonete JP: \n" + sanduicheJP);
        System.out.println("\n\n");

        SanduichesIngredientFactory factoryRT = new SanduichesIngredientFactoryRT();
        Sanduiche sanduicheRT = new Sanduiche(factoryRT);
        System.out.println("Lanchonete RT: \n" + sanduicheRT);
        System.out.println("\n\n");
    }
}

