import org.aspectj.lang.Signature;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

public aspect Sequence {

    ArrayList<String> classes = new ArrayList<String>();
      ArrayList<String> messages = new ArrayList<String>();
     StringBuilder Messagewrite = new StringBuilder() ;

      before() : execution(public static void main(..)) || (!within(Sequence) &&
              call(* *.*(..)) &&
              !call(* java..*.*(..)) &&
              !cflow(execution(*.new(..))))  {

          String identified = "Main";
            if (thisJoinPoint.getThis() != null)
                identified = thisJoinPoint.getThis().getClass().getName();


            if(!classes.contains(identified))
                        classes.add(identified);

            String targetobject = "Main";
            if (thisJoinPoint.getTarget() != null)
           targetobject = thisJoinPoint.getTarget().getClass().getName();


            Signature Signature = thisJoinPoint.getSignature();
            String modifier = Signature.toString().split(" ")[0];
            String adr = Signature.toString().split("\\.")[1];
            String message = adr+ " : " + modifier;
            messages.add("message(" + identified + "," + targetobject + "," + "\"" + message + "\"" + ");\n");
                  }


      after() : execution(public static void main(..)) {
          Messagewrite.append(".PS\n");
          Messagewrite.append("copy \"sequence.pic\";\n");
        for(String subclass : classes )
        {
            Messagewrite.append("object(" + subclass + ",\"" + subclass + "\");\n");
        }

        for(String msg : messages )
        {
            Messagewrite.append(msg);

        }

        for(String subclass : classes )
        {
            Messagewrite.append("complete(" + subclass + ");\n");
        }
        Messagewrite.append(".PE\n");

        Path file = Paths.get("sequence_inter.txt");
          try {
              Files.write(file, Messagewrite.toString().getBytes());
            } catch(IOException ie) {
                ie.printStackTrace();
                        }

      }

}