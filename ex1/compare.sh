#!/bin/bash

# Check if the correct number of arguments is provided
if [ "$#" -ne 2 ]; then
    echo "Usage: $0 file1.txt file2.txt"
    exit 1
fi

# Assign arguments to variables for better readability
file1="$1"
file2="$2"

# Check if both files exist
if [ ! -f "$file1" ]; then
    echo "Error: File '$file1' does not exist."
    exit 1
fi

if [ ! -f "$file2" ]; then
    echo "Error: File '$file2' does not exist."
    exit 1
fi

# Compare files character by character
diff_pos=0
identical=true

exec 3<"$file1" 4<"$file2"

while true; do
    char1=$(dd bs=1 count=1 2>/dev/null <&3)
    char2=$(dd bs=1 count=1 2>/dev/null <&4)
    
    # Check if both reached EOF
    if [ -z "$char1" ] && [ -z "$char2" ]; then
        break
    fi

    # Check for mismatch
    if [ "$char1" != "$char2" ]; then
        echo "Files differ at position $diff_pos."
        echo "File1: '$char1' | File2: '$char2'"
        identical=false
        break
    fi

    # Increment position counter
    ((diff_pos++))
done

# Close file descriptors
exec 3<&-
exec 4<&-

if $identical; then
    echo "The files are identical."
fi
