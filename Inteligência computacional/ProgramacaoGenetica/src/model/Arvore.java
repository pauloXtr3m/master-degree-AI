package model;

/**
 * Created by paulo on 08/05/17.
 */
public class Arvore {
    No root;

    public Arvore(String arvoreString){
        int key = 0;
        for(int i = 0; i < arvoreString.length(); i++){
            if(arvoreString.charAt(i) == '('){
                char funcao = arvoreString.charAt(i + 1);
                addNo(key, Character.toString(funcao));
                key++;
                i++;
            }else if(arvoreString.charAt(i) != ')'){
                char numero = arvoreString.charAt(i);
                addNo(key, Character.toString(numero));
                key++;
                i++;
            }
        }
    }
    public Arvore(){}

    public void addNo(int key, String name) {

        // Create a new No and initialize it

        No newNo = new No(key, name);

        // If there is no root this becomes root

        if (root == null) {

            root = newNo;

        } else {

            // Set root as the No we will start
            // with as we traverse the tree

            No focusNo = root;

            // Future parent for our new No

            No parent;

            while (true) {

                // root is the top parent so we start
                // there

                parent = focusNo;

                // Check if the new No should go on
                // the left side of the parent No

                if (key < focusNo.key) {

                    // Switch focus to the left child

                    focusNo = focusNo.filhoEsquerdo;

                    // If the left child has no children

                    if (focusNo == null) {

                        // then place the new No on the left of it

                        parent.filhoEsquerdo = newNo;
                        return; // All Done

                    }

                } else { // If we get here put the No on the right

                    focusNo = focusNo.filhoDireito;

                    // If the right child has no children

                    if (focusNo == null) {

                        // then place the new No on the right of it

                        parent.filhoDireito = newNo;
                        return; // All Done

                    }

                }

            }
        }

    }

    // All Nos are visited in ascending order
    // Recursion is used to go to one No and
    // then go to its child Nos and so forth

    public void inOrderTraverseTree(No focusNo) {

        if (focusNo != null) {

            // Traverse the left No

            inOrderTraverseTree(focusNo.filhoEsquerdo);

            // Visit the currently focused on No

            System.out.println(focusNo);

            // Traverse the right No

            inOrderTraverseTree(focusNo.filhoDireito);

        }

    }

    public void preorderTraverseTree(No focusNo) {

        if (focusNo != null) {

            System.out.println(focusNo);

            preorderTraverseTree(focusNo.filhoEsquerdo);
            preorderTraverseTree(focusNo.filhoDireito);

        }

    }

    public void postOrderTraverseTree(No focusNo) {

        if (focusNo != null) {

            postOrderTraverseTree(focusNo.filhoEsquerdo);
            postOrderTraverseTree(focusNo.filhoDireito);

            System.out.println(focusNo);

        }

    }

    public No findNo(int key) {

        // Start at the top of the tree

        No focusNo = root;

        // While we haven't found the No
        // keep looking

        while (focusNo.key != key) {

            // If we should search to the left

            if (key < focusNo.key) {

                // Shift the focus No to the left child

                focusNo = focusNo.filhoEsquerdo;

            } else {

                // Shift the focus No to the right child

                focusNo = focusNo.filhoDireito;

            }

            // The No wasn't found

            if (focusNo == null)
                return null;

        }

        return focusNo;

    }
    }
