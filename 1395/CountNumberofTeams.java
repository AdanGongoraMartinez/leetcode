public class CountNumberofTeams {
  public static void main(String[] args) {
    int[] rating = { 2, 5, 3, 4, 1 };
    System.out.println(makeTeams(rating));
  }

  public static int makeTeams(int[] rating) {
    int teams = 0;

    // usar al soldado del medio
    for (int mid = 0; mid < rating.length; mid++) {
      int leftSmaller = 0;
      int rightLarger = 0;

      // obtener los soldados mas pequeños del lado izquierdo
      for (int left = mid - 1; left >= 0; left--) {
        if (rating[left] < rating[mid])
          leftSmaller++;
      }

      // obtener los soldados mas grandes del lado derecho
      for (int right = mid + 1; right < rating.length; right++) {
        if (rating[right] > rating[mid])
          rightLarger++;
      }

      teams += leftSmaller * rightLarger;
      System.out.println(leftSmaller + "" + rightLarger + "   " + teams);

      int leftLarger = mid - leftSmaller;
      int rightSmaller = rating.length - mid - 1 - rightLarger;

      teams += leftLarger * rightSmaller;
      System.out.println(leftLarger + "" + rightSmaller + "   " + teams);
    }

    return teams;
  }
}
