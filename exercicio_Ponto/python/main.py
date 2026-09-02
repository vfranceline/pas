from Ponto import Ponto
from Ponto3D import Ponto3D

def main():
    p = Ponto()
    print(p)

    p3d = Ponto3D(1, 2, 3)
    print("Ponto x=" + p3d.getX()+ " y="+ p3d.getY())

    print("Ponto z=" + p3d.z())
if __name__ == "__main__":
    main()