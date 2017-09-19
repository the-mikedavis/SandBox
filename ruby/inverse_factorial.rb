def inverse (number)
    n = 1
    p = n
    mul = 1
    while mul < number do
        p = n
        n = n + 1
        mul *= n
    end
    puts p
end

ARGV.each do |no|
    inverse no.to_i
end
