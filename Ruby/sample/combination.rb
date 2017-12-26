coins = [500, 100, 50, 10]
#順序なし、重複を許さない
printf("combination = ")
coins.combination(3) {|a, b, c| printf("(%d, %d, %d), ", a, b, c) }
puts ""

#順序なし、重複を許す
printf("repeated_combination = ")
coins.repeated_combination(3) {|a, b, c| printf("(%d, %d, %d) ,", a, b, c) }
puts ""

#順序あり、重複を許す
printf("repeated_permutation = ")
coins.repeated_permutation(3) {|a, b, c| printf("(%d, %d, %d), ", a, b, c) }
puts ""
