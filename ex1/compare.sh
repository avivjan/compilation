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

# Initialize line and character counters
line_num=1
identical=true

# Read files line by line
while IFS= read -r line1 <&3 || IFS= read -r line2 <&4; do
    # Remove trailing carriage return (Windows line endings) and trim spaces
    line1=$(echo "$line1" | tr -d '\r' | sed 's/^[ \t]*//;s/[ \t]*$//')
    line2=$(echo "$line2" | tr -d '\r' | sed 's/^[ \t]*//;s/[ \t]*$//')

    # Check if lines differ
    if [ "$line1" != "$line2" ]; then
        max_len=${#line1}
        if [ ${#line2} -gt $max_len ]; then
            max_len=${#line2}
        fi

        # Compare characters within the lines
        for ((i=0; i<max_len; i++)); do
            char1="${line1:i:1}"
            char2="${line2:i:1}"

            if [ "$char1" != "$char2" ]; then
                char_pos=$((i + 1))
                echo "Files differ at line $line_num, position $char_pos."
                echo "File1: '$char1' | File2: '$char2'"
                identical=false
                break 2
            fi
        done
    fi

    # Increment line number
    ((line_num++))
done 3<"$file1" 4<"$file2"

# Close file descriptors
exec 3<&-
exec 4<&-

# Final output
if $identical; then
    echo "The files are identical."
fi
