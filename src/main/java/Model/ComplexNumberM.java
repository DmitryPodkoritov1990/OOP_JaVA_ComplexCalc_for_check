package Model;

public class ComplexNumberM {


    public static class ComplexNumber {
        public static final int XY = 0;
        public static final int RCIZ = 1;
        private double real;
        private double mnimaya;

        public ComplexNumber(){
            real = 0.0;
            mnimaya = 0.0;
        }

        public ComplexNumber(double real, double mnimaya) {
            this.real = real;
            this.mnimaya = mnimaya;
        }
        public void add(ComplexNumber z){
            set(add(this, z));
        }

        public void substract(ComplexNumber z){
            set(substract(this, z));
        }

        public void multiple(ComplexNumber z){set(multiple(this,z));}

        public void divide(ComplexNumber z){set(divide(this,z));}

        public void set(ComplexNumber z)
        {
            this.real = z.real;
            this.mnimaya = z.mnimaya;
        }

        public static ComplexNumber add(ComplexNumber z1, ComplexNumber z2)
        {
            return new ComplexNumber(z1.real + z2.real, z1.mnimaya + z2.mnimaya);
        }

        public static ComplexNumber substract(ComplexNumber z1, ComplexNumber z2)
        {
            return new ComplexNumber(z1.real - z2.real, z1.mnimaya - z2.mnimaya);
        }
        public static ComplexNumber multiple(ComplexNumber z1, ComplexNumber z2){
            return new ComplexNumber(z1.real * z2.real - z1.mnimaya * z2.mnimaya, z1.real* z2.mnimaya + z1.mnimaya * z2.real);

        }
        public static ComplexNumber divide(ComplexNumber z1, ComplexNumber z2)
        {
            return new ComplexNumber((z1.real * z2.real + z1.mnimaya * z2.mnimaya / (z2.real * z2.real + z2.mnimaya * z2.mnimaya)),
                    (z1.mnimaya * z2.real - z1.real * z2.mnimaya / (z2.real * z2.real + z2.mnimaya * z2.mnimaya)));
        }

        public ComplexNumber conjugate()
        {
            return new ComplexNumber(this.real,-this.mnimaya);
        }

        @Override
        public String toString()
        {
            String re = this.real+"";
            String im = "";
            if(this.mnimaya < 0)
                im = this.mnimaya+"i";
            else
                im = "+"+this.mnimaya+"i";
            return re+im;
        }
        public double getRe()
        {
            return this.real;
        }
        public double getIm()
        {
            return this.mnimaya;
        }

        public static ComplexNumber parseComplex(String s)
        {
            s = s.replaceAll(" ","");
            ComplexNumber parsed = null;
            if(s.contains(String.valueOf("+")) || (s.contains(String.valueOf("-")) && s.lastIndexOf('-') > 0))
            {
                String re = "";
                String im = "";
                s = s.replaceAll("i","");
                s = s.replaceAll("I","");
                if(s.indexOf('+') > 0)
                {
                    re = s.substring(0,s.indexOf('+'));
                    im = s.substring(s.indexOf('+')+1,s.length());
                    parsed = new ComplexNumber(Double.parseDouble(re),Double.parseDouble(im));
                }
                else if(s.lastIndexOf('-') > 0)
                {
                    re = s.substring(0,s.lastIndexOf('-'));
                    im = s.substring(s.lastIndexOf('-')+1,s.length());
                    parsed = new ComplexNumber(Double.parseDouble(re),-Double.parseDouble(im));
                }
            }
            else
            {
                // Pure imaginary number
                if(s.endsWith("i") || s.endsWith("I"))
                {
                    s = s.replaceAll("i","");
                    s = s.replaceAll("I","");
                    parsed = new ComplexNumber(0, Double.parseDouble(s));
                }
                // Pure real number
                else
                {
                    parsed = new ComplexNumber(Double.parseDouble(s),0);
                }
            }
            return parsed;
        }

        @Override
        public final boolean equals(Object z)
        {
            if (!(z instanceof ComplexNumber))
                return false;
            ComplexNumber a = (ComplexNumber) z;
            return (real == a.real) && (mnimaya == a.mnimaya);
        }

    //    public String format(int format_id) throws IllegalArgumentException
    //    {
    //        String out = "";
    //        if(format_id == XY)
    //            out = toString();
    //        else if(format_id == RCIZ)
    //        {
    //            out = mod()+" cis("+getArg()+")";
    //        }
    //        else
    //        {
    //            throw new IllegalArgumentException("Unknown Complex Number format.");
    //        }
    //        return out;
    //    }
    }
}
