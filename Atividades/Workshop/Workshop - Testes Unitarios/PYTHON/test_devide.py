import pytest
import codigo as co

@pytest.mark.parametrize("numerador, denominador, esperado", [
    (10, 2, 5),
    (-10, 2, -5),
    (0, 5, 0),
    (3, 3, 1)
])
def test_divide_parametrized(numerator, denominator, expected):
    assert co.divide(numerator, denominator) == expected

def test_divide_by_zero():
    with pytest.raises(ValueError):
        co.divide(5, 0)

def test_divide_invalid_type():
    with pytest.raises(TypeError):
        co.divide(5, "two")
