N = 29
boy, girl = 1, 1
printf("i = 1, boy = %d, girl = %d\n", boy, girl)
N.times{|i|
  # 次に男子が来るのは、最後が男子でも女子でもよい
  # 次に女子が来るのは、最後が男子の場合のみ
  boy, girl = boy + girl, boy
  printf("i = %d, boy = %d, girl = %d\n", i+2, boy, girl)
}
puts boy + girl
