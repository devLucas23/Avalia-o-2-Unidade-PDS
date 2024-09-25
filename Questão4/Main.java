package Questão4;

// Interfaces para os ingredientes
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
interface SanduichesIngredientFactory {
    PaoIF criarPao();
    QueijoIF criarQueijo();
    PresuntoIF criarPresunto();
    SaladaIF criarSalada();
}

// Implementação concreta dos ingredientes
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

    public String getDescricao() {
        return "Sanduíche com Pão: " + pao.getTipoPao() + ",\nQueijo: " + queijo.getTipoQueijo() +
                ",\nPresunto: " + presunto.getTipoPresunto() + ",\nSalada: " + (salada.temSalada() ? "Com verdura" : "Sem verdura");
    }

    public double getPreco() {
        return 10.0; 
    }
}

// uso do Decorator nas próximas funções 
abstract class SanduicheDecorator extends Sanduiche {
    protected Sanduiche sanduiche;

    public SanduicheDecorator(Sanduiche sanduiche) {
        // Não chamamos o super com null, pois já temos um sanduíche válido
        super(new SanduichesIngredientFactoryCG()); // Passar a fábrica da fábrica
        this.sanduiche = sanduiche;
    }

    @Override
    public String getDescricao() {
        return sanduiche.getDescricao();
    }

    @Override
    public double getPreco() {
        return sanduiche.getPreco();
    }
}

class SanduicheGourmet extends SanduicheDecorator {
    public SanduicheGourmet(Sanduiche sanduiche) {
        super(sanduiche);
    }

    @Override
    public String getDescricao() {
        return sanduiche.getDescricao() + " - Versão Gourmet";
    }

    @Override
    public double getPreco() {
        return sanduiche.getPreco() + 5.0;  // Adiciona 5 reais ao preço base
    }
}

class SanduicheVegano extends SanduicheDecorator {
    public SanduicheVegano(Sanduiche sanduiche) {
        super(sanduiche);
    }

    @Override
    public String getDescricao() {
        return sanduiche.getDescricao() + " - Versão Vegano";
    }

    @Override
    public double getPreco() {
        return sanduiche.getPreco() + 7.0;  
    }
}

public class Main {
    public static void main(String[] args) {
        SanduichesIngredientFactory factoryCG = new SanduichesIngredientFactoryCG();
        Sanduiche sanduicheCG = new Sanduiche(factoryCG);

        Sanduiche sanduicheGourmetCG = new SanduicheGourmet(sanduicheCG);
        System.out.println("Lanchonete CG Gourmet: \n" + sanduicheGourmetCG.getDescricao() + "\nPreço: R$ " + sanduicheGourmetCG.getPreco());
        System.out.println("\n\n");

        SanduichesIngredientFactory factoryJP = new SanduichesIngredientFactoryJP();
        Sanduiche sanduicheJP = new Sanduiche(factoryJP);
        Sanduiche sanduicheVeganoJP = new SanduicheVegano(sanduicheJP);
        System.out.println("Lanchonete JP Vegano: \n" + sanduicheVeganoJP.getDescricao() + "\nPreço: R$ " + sanduicheVeganoJP.getPreco());
        System.out.println("\n\n");

        SanduichesIngredientFactory factoryRT = new SanduichesIngredientFactoryRT();
        Sanduiche sanduicheRT = new Sanduiche(factoryRT);
        Sanduiche sanduicheGourmetVeganoRT = new SanduicheVegano(new SanduicheGourmet(sanduicheRT));
        System.out.println("Lanchonete RT Gourmet e Vegano: \n" + sanduicheGourmetVeganoRT.getDescricao() + "\nPreço: R$ " + sanduicheGourmetVeganoRT.getPreco());
        System.out.println("\n\n");
    }
}