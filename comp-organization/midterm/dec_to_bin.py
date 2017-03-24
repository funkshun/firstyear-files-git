import sys
if __name__ == "__main__":
    val = input()
    print(dec_to_bin(val))

def dec_to_bin(x):
    """TODO: Docstring for dec_to_bin.
    :returns: TODO

    """
    return int(bin(x)[2:1])
