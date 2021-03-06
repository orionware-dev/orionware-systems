package gov.pnnl.aparapi.sample.mdarray;
import com.amd.aparapi.Kernel;

class ZMatMul3D extends Kernel{
   boolean[][][] A;

   boolean[][][] B;

   boolean[][][] C;

   int N;

   public ZMatMul3D(boolean[][][] A, boolean[][][] B, boolean[][][] C, int N) {
      this.A = A;
      this.B = B;
      this.C = C;
      this.N = N;
   }

   @Override public void run() {
      int id = getGlobalId();
      int i = id / (N * N);
      int j = (id / N) % N;
      int k = id % N;
      for (int l = 0; l < N; l++) {
         C[i][j][k] ^= A[i][j][l] & B[l][j][k];
      }
   }
}
