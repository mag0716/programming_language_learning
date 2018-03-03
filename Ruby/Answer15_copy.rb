N = 10
STEPS = 4

dp = Array.new(N + 1, 0)
cnt = 0
dp[N] = 1

N.times{|i|
  (N+1).times{|j|
    (1..STEPS).each{|k|
      break if k > j
      dp[j-k] += dp[j]
    }
    dp[j] = 0
  }
  p dp
  cnt += dp[0] if i%2==1
}
puts cnt
