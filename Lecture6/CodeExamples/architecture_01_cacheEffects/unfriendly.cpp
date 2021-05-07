#include <iostream>
#include <thread>
#include <vector>
#include <algorithm>
#include <cassert>

int main() {
  const int N = 800000000;

  std::vector<int> data(N);
  std::fill(data.begin(), data.end(), 1);

  // Given an array of N ones,
  // sum up every 64nd array slot,
  // and that 64 times.
  // This should NOT be cache friendly.

  long result = 0;
  for (int i = 0; i < 64; ++i)
    for (int j = 0; j < N; j += 64)
      result += data[j];

  assert(result == N);

  std::cout << "-- done --\n";
}
