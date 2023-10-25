package Model;

public class ComplexNumber1 {


    public static final int XY = 0;
    public static final int RCIZ = 1;
    double real;
    double mnimaya;

    public ComplexNumber1() {
        real = 0.0;
        mnimaya = 0.0;
    }

    public ComplexNumber1(double real, double mnimaya) {
        this.real = real;
        this.mnimaya = mnimaya;
    }

    public ComplexNumber1 conjugate() {
        return new ComplexNumber1(this.real, -this.mnimaya);
    }

    @Override
    public String toString() {
        String re = this.real + "";
        String im = "";
        if (this.mnimaya < 0)
            im = this.mnimaya + "i";
        else
            im = "+" + this.mnimaya + "i";
        return re + im;
    }

    public double getRe() {
        return this.real;
    }

    public double getIm() {
        return this.mnimaya;
    }

    public static ComplexNumber1 parseComplex(String s) {
        s = s.replaceAll(" ", "");
        ComplexNumber1 parsed = null;
        if (s.contains(String.valueOf("+")) || (s.contains(String.valueOf("-")) && s.lastIndexOf('-') > 0)) {
            String re = "";
            String im = "";
            s = s.replaceAll("i", "");
            s = s.replaceAll("I", "");
            if (s.indexOf('+') > 0) {
                re = s.substring(0, s.indexOf('+'));
                im = s.substring(s.indexOf('+') + 1, s.length());
                parsed = new ComplexNumber1(Double.parseDouble(re), Double.parseDouble(im));
            } else if (s.lastIndexOf('-') > 0) {
                re = s.substring(0, s.lastIndexOf('-'));
                im = s.substring(s.lastIndexOf('-') + 1, s.length());
                parsed = new ComplexNumber1(Double.parseDouble(re), -Double.parseDouble(im));
            }
        }
        else
                {
                // Pure imaginary number
                if(s.endsWith("i") || s.endsWith("I"))
                {
                s = s.replaceAll("i","");
                s = s.replaceAll("I","");
                parsed = new ComplexNumber1(0, Double.parseDouble(s));
                }
                // Pure real number
                else
                {
                parsed = new ComplexNumber1(Double.parseDouble(s),0);
                }
                }
                return parsed;
                }

    @Override
    public final boolean equals(Object z)
    {
        if (!(z instanceof ComplexNumber1))
            return false;
        ComplexNumber1 a = (ComplexNumber1) z;
        return (real == a.real) && (mnimaya == a.mnimaya);
    }

}
