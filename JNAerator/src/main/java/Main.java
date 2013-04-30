import com.ochafik.lang.jnaerator.runtime.LibraryExtractor;
import com.ochafik.lang.jnaerator.runtime.MangledFunctionMapper;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;


/**
 * User: H&B Biomedical Technologies s.r.o.
 * Date: 29.4.13
 * Time: 17:54
 *
 *
 * CPP file
 *
 *    #include <stdio.h>
 *
 *    extern "C"
 *     {
 *       __declspec(dllexport) void halloFromC()
 *       {
 *           printf ("Hello from native code !\n");
 *        }
 *       }
 *
 *
 */
public class Main {

    // Generated source via JNAeretor with JNA
    public interface CLibrary extends Library {
        public static final String JNA_LIBRARY_NAME = LibraryExtractor.getLibraryPath("src/main/resources/lib/ctest.dll", true, CLibrary.class);
        public static final NativeLibrary JNA_NATIVE_LIB = NativeLibrary.getInstance(CLibrary.JNA_LIBRARY_NAME, MangledFunctionMapper.DEFAULT_OPTIONS);
        public static final CLibrary INSTANCE = (CLibrary)Native.loadLibrary(CLibrary.JNA_LIBRARY_NAME, CLibrary.class, MangledFunctionMapper.DEFAULT_OPTIONS);

        void halloFromC();
    }



    public static void main(String[] args) {
         CLibrary.INSTANCE.halloFromC();
    }
}
