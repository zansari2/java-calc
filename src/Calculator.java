/**
 * Emulates calculator functions for two variables
 */
public class Calculator
{
    //  Variables
    /**
     * Holds the first variable
     */
    private double var1;
    /**
     * Holds the second variable
     */
    private double var2;

    //  Constructors
    /**
     * Default constructor returns object with default values of 0
     */
    public Calculator()
    {
        this.var1 = 0;
        this.var2 = 0;
    }

    //  Methods
    /**
     * @return the var1
     */
    public double getVar1() 
    {
        return var1;
    }
    /**
     * @return the var2
     */
    public double getVar2() 
    {
        return var2;
    }
    /**
     * @param var1 the var1 to set
     */
    public void setVar1(double var1) 
    {
        this.var1 = var1;
    }
    /**
     * @param var2 the var2 to set
     */
    public void setVar2(double var2) 
    {
        this.var2 = var2;
    }
    /**
     * Adds the current variables
     * @return the sum
     */
    public double sum()
    {
        return getVar1()+getVar2();
    }
    /**
     * Subtracts var1 by var2
     * @return the difference
     */
    public double diff()
    {
        return getVar1()-getVar2();
    }
    /**
     * Multiplies the current variables
     * @return the product
     */
    public double prod()
    {
        return getVar1()*getVar2();
    }
    /**
     * Divides the current variables
     * @return the quotient
     */
    public double quot()
    {
        return getVar1()/getVar2();
    }
    // Main
    public static void main(String[] args) 
    {
        // A series of tests for assessing the class functionality
        String message1 = "Success ";
        int message2 = 1;
        Calculator c1 = new Calculator();
        if(c1.getVar1()==0&&c1.getVar2()==0)   
        {
            System.out.println(message1+message2);
            message2++;
        }
        c1.setVar1(2);
        c1.setVar2(3);
        if(c1.getVar1()==2&&c1.getVar2()==3)
        {
            System.out.println(message1+message2);
            message2++;
        }
        if(c1.sum()==5&&c1.diff()==-1)
        {
            System.out.println(message1+message2);
            message2++;
        }
        if(c1.prod()==6&&c1.quot()==(2.0/3.0))
        {
            System.out.println(message1+message2);
            message2++;
        }
    }
}