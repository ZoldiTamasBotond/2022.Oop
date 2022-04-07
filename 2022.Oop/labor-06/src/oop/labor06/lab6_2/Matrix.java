package oop.labor06.lab6_2;

import java.util.Random;

public class Matrix {
    private double[][] data;
    private final int rows;
    private final int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data= new double[rows][columns];
    }

    public Matrix(double[][] data) {
        this.rows=data[0].length;
        this.columns= data.length;
        this.data= new double[rows][columns];
        for(int i=0;i<this.rows;i++)
        {
            System.arraycopy(data[i], 0, this.data[i], 0, this.columns);
        }
    }

    public Matrix(Matrix matrix) {
        this.rows=matrix.rows;
        this.columns=matrix.columns;
        this.data= new double[rows][columns];
        for(int i=0;i<this.rows;i++)
        {
            System.arraycopy(matrix.data[i], 0, this.data[i], 0, this.columns);
        }
    }

    public void fillRandom(double min,double max){
        Random random= new Random();
        for(int i=0;i<this.rows;i++)
        {
            for (int j=0;j<this.columns;j++){
                this.data[i][j]= random.nextDouble(min, max);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void printMatrix(){

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    System.out.print(this.data[i][j] + " ");
                }
                System.out.println();
            }
        }

    public static Matrix add(Matrix matrix1,Matrix matrix2){
        if(matrix1.rows== matrix2.rows && matrix1.columns== matrix2.columns){
            Matrix add= new Matrix(matrix1.rows, matrix1.columns);
            for(int i=0;i<matrix1.rows;i++)
            {
                for (int j=0;j<matrix1.columns;j++){
                    add.data[i][j]=matrix1.data[i][j]+matrix2.data[i][j];
                }
            }
            return add;
        }
        else {
            return null;
        }
    }

    public static Matrix multiply(Matrix matrix1,Matrix matrix2) {
        if (matrix1.columns == matrix2.rows) {
            Matrix multiply = new Matrix(matrix1.rows, matrix2.columns);
            for (int i = 0; i < matrix1.rows; i++) {
                for (int j = 0; j < matrix2.columns; j++) {
                    for (int k = 0; k < matrix2.rows; k++) {
                        multiply.data[i][j]+=matrix1.data[i][k]*matrix2.data[k][j];
                    }
                }
            }
                return multiply;
            }
        else{
                return null;
            }
        }

        public static Matrix transpose (Matrix matrix)
        {
            Matrix transpose = new Matrix(matrix.columns, matrix.rows);
            for (int i = 0; i < matrix.rows; i++) {
                for (int j = 0; j < matrix.columns; j++) {
                    transpose.data[j][i] = matrix.data[i][j];
                }
            }
            return transpose;
        }
    }
