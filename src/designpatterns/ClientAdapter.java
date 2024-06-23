package designpatterns;

class RoundPeg{
    int radious;
    public RoundPeg(){

    }
    public RoundPeg(int radious){
        this.radious=radious;
    }
    public int getRadious() {
        return radious;
    }
}

class RoundeHole{
    int radious;

    public RoundeHole(int radious){
        this.radious = radious;
    }

    public boolean fits(RoundPeg rp){
        return radious>=rp.getRadious();
    }
}

class SquarePeg{
    int width;

    public SquarePeg(int width){
        this.width=width;
    }

    public int getWidth() {
        return width;
    }
}

class SquarePegAdapter extends RoundPeg{

    SquarePeg sp;

    public SquarePegAdapter(SquarePeg sp){
        this.sp= sp;
    }

    @Override
    public int getRadious(){
        return sp.getWidth();
    }

}

public class ClientAdapter {

    public static void main(String[] args) {
        
        RoundeHole roundeHole = new RoundeHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        System.out.println(roundeHole.fits(roundPeg));

        SquarePeg squarePeg = new SquarePeg(5);
        System.out.println(roundeHole.fits(new SquarePegAdapter(squarePeg)));


        SquarePeg squarePeg2 = new SquarePeg(10);

        System.out.println(roundeHole.fits(new SquarePegAdapter(squarePeg2)));
    }
    
}
