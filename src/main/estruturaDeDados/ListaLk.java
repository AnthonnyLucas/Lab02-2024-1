package estruturaDeDados;

public class ListaLk implements Lista{
    private int[] elementos;
    private int tamanho;
    private static final int CAPACIDADE_INICIAL = 10;

    public ListaLk() {
        this.elementos = new int[CAPACIDADE_INICIAL];
        this.tamanho = 0;
    }

    @Override
    public int buscaIndice(int valor){
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice){

        if(buscaIndice >= 0 && buscaIndice <= tamanho){

            //Mudar elementos para direita 

            for(int i = tamanho - 1; i >= buscaIndice; i--){
                elementos[i + 1] = elementos[i];
            }
            elementos[buscaIndice] = valor;
            tamanho++;
        }else{
            System.out.println("Indice não encontrado");
        }
    }

    @Override
    public void insereElemento(int valor) {     
        if(tamanho < elementos.length){
            elementos[tamanho++] = valor;
        }else{
            System.out.println("A lista está cheia, não é possivel inserir mais elementos");
        } 
    }

    @Override
    public void insereInicio(int valor){
        insereElementoPosicao(valor, 0);
    }

    @Override
    public void insereFim(int valor){
        insereElemento(valor);
    }

    @Override
    public void removeIndice(int indice){
        if(indice >= 0 && indice < tamanho){
            //Move os elementos para a esquerda
            for(int i = indice; i < tamanho - 1; i++ ){
                elementos[i] = elementos[i + 1];
            } 
            tamanho--;
        }else{
            System.out.println("Indice não encontrado");
        }
    }

    @Override
    public void removeInicio(){
        if(tamanho > 0){
            removeIndice(0);
        }else{
            System.out.println("Lista Vazia");
        }
    }

    @Override
    public void removeFim(){
        if(tamanho > 0){
            tamanho--;
        }else{
            System.out.println("Lista Vazia");    
        }
    }

    @Override
    public boolean buscaElemento(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == valor) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int sucessor(int valor) {
        int sucessor = Integer.MAX_VALUE;
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] > valor && elementos[i] < sucessor) {
                sucessor = elementos[i];
            }
        }
        return sucessor == Integer.MAX_VALUE ? -1 : sucessor;
    }

    @Override
    public int minimo(){
        if (tamanho == 0) {
            throw new IllegalStateException("Lista vazia");
        }
        int min = elementos[0];
        for (int i = 1; i < tamanho; i++) {
            if (elementos[i] < min) {
                min = elementos[i];
            }
        }
        return min;
    }

    @Override
    public int maximo(){
        if (tamanho == 0) {
            throw new IllegalStateException("Lista vazia");
        }
        int max = elementos[0];
        for (int i = 1; i < tamanho; i++) {
            if (elementos[i] > max) {
                max = elementos[i];
            }
        }
        return max;
    }

    @Override
    public int predecessor(int valor){
        int predecessor = -1;
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] < valor && elementos[i] > predecessor) {
                predecessor = elementos[i];
            }
        }
        return predecessor;
    }

    @Override
    public void remove(int valor){

        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] == valor) {
                //remove os elementos e os move para a esquerda
                for(int j = i; j < tamanho - 1; j++){
                    elementos[j] = elementos[j + 1];
                }
                tamanho--;
                break;
            }
        }

    }
    
}
