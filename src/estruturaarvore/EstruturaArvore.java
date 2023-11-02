package estruturaarvore;



public class EstruturaArvore {
    tipoNo raiz;    
    
    //**************INSERINDO*****************//
    public void inserirInicio(int info) {
        tipoNo novo = new tipoNo();
        novo.setInfo(info);
        novo.setMaior(null);
        novo.setMenor(null);
    
    if (raiz == null) {
        raiz = novo;
    } else {
        tipoNo aux = raiz;
        //Percorrendo a arvore
        while (true){
            //Verificando se o numero informado eh maior que o numero anterior
            if (aux.getInfo() > novo.getInfo()) {
                if (aux.getMenor() == null) {
                    aux.setMenor(novo);
                    break;
                } else {
                    aux = aux.getMenor();
                }
            } else {
                if (aux.getMaior() == null) {
                    aux.setMaior(novo);
                    break;
                } else {
                    aux = aux.getMaior();
                    }
                }
            }
        }
    }
    
   //**************REMOVER*****************//
   public void remover(int info) {
    if (raiz != null) {
        raiz = removerRecursivo(raiz, info);
      }else {
        System.out.println("Arvore vazia");
     }
    }

    public tipoNo removerRecursivo(tipoNo aux, int info) {
       if (aux == null) {
        System.out.println("Numero nao encontrado na arvore");
        return aux;
    }
       if (info < aux.getInfo()) {
        aux.setMenor(removerRecursivo(aux.getMenor(), info));
       } else if (info > aux.getInfo()) {
        aux.setMaior(removerRecursivo(aux.getMaior(), info));
       } else {
        //No com o valor a ser removido encontrado
        //No com apenas um filho ou nenhum filho
        if (aux.getMenor() == null) {
            return aux.getMaior();
        } else if (aux.getMaior() == null) {
            return aux.getMenor();
        }
            //No com dois filhos encontrando o no sucessor em ordem o menor no
            aux.setInfo(encontrarMinimoValor(aux.getMaior()));
            //Removendo o no sucessor em ordem
            aux.setMaior(removerRecursivo(aux.getMaior(), aux.getInfo()));
        }
        return aux;
    }
    
    public int encontrarMinimoValor(tipoNo raiz) {
        int minimoValor = raiz.getInfo();
        while (raiz.getMenor() != null) {
            minimoValor = raiz.getMenor().getInfo();
            raiz = raiz.getMenor();
        }
      return minimoValor;
    }
    
    
    //**************BUSCAR*****************//
    public void buscar(int info) {
    tipoNo aux = raiz;

    if (aux != null) {
        while (true) {
            if (aux.getInfo() > info) {
                if (aux.getMenor() != null && aux.getMenor().getInfo() == info) {
                    System.out.println("O numero: " + info + " Foi encontrado na arvore");
                    break;
                } else {
                    aux = aux.getMenor();
                }
            } else if (aux.getInfo() < info) {
                if (aux.getMaior() != null && aux.getMaior().getInfo() == info) {
                    System.out.println("O numero: " + info + " Foi encontrado na arvore");
                    break;
                } else {
                    aux = aux.getMaior();
                }
            } else {
                // Quando existir apenas um numero na arvore
                System.out.println("O numero: " + info + " Foi encontrado na arvore");
                break;
            }
        }
        if (aux == null) {
            System.out.println("Valor " + info + " nao foi encontrado na Arvore.");
           }
        } else {
        System.out.println("Arvore vazia!!");
        }
    }



    //************IMPRIMINDO*****************//
    public void imprimir(tipoNo aux){
        //Verificando se a fila esta Vazia!
        if(raiz == null){System.out.println("Arvore vazia!!");}
        //Utilizando funcao recursiva para imprimir a parte Menor e a Maior da arvore binaria
        if (aux != null) {
            imprimir(aux.getMenor());
            System.out.print("|" + aux.getInfo() + "| ");
            imprimir(aux.getMaior());
        }
    }   
    
    //**************MENU*****************//
    public void menu(){
            int info,opcao=0;
            System.out.print("\n------------| Menu |------------\n");
	while(opcao!=-1){
            opcao = Input.readInt("\nDigite a opcao: \n(1) Inserir \n(2) Remover \n(3) Buscar \n(4) Imprimir \n(-1) Sair \nOpcao: ");
            switch(opcao){
		
                case 1://Inserir
                    info = Input.readInt("***INSERIR***\nInforme o numero: ");
                    inserirInicio(info);
                    break;
                    
                case 2://Remover
                    info = Input.readInt("***REMOVER***\nInforme o numero: ");
                    remover(info);
                    break;
                    
                case 3://Buscar
                    info = Input.readInt("***BUSCAR***\nInforme o numero: ");
                    buscar(info);
                    break;
                    
                case 4://Imprimir
                    System.out.println("***Imprimindo***");
                    imprimir(raiz);
                    break;
				
		default:
                    System.out.println("Opcao invalida!");
		break;			
            }		
	}
    } 
    
    public static void main(String[] args) {
            System.out.println("\n************ Lista Arvore ************\n");
            EstruturaArvore F = new EstruturaArvore();
	    F.menu();
	    System.out.println("\n************ Fim programa ************\n");
    }
}
