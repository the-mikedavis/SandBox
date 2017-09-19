def iterate (start)
    n = start
    p = 0
    while n != p do
        p = n
        n = (start / Math::log(n, 2)).round
        puts n
    end
end

ARGV.each do |no|
    iterate no.to_i
end
