package it.reply.model;

public class Grid {
    public GridElem[][] e;

    public Grid(int numRighe, int numColonne) {
        e = new GridElem[numRighe][numColonne];
    }
}
