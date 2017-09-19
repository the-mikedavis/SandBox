#! /bin/tcsh

if (5 < 0) then
    echo "yep"
else
    if (3 < 4) then
        echo "ok"
    else
        echo "nope"
    endif
endif

