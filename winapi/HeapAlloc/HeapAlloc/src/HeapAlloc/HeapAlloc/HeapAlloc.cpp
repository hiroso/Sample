// �w�b�_�t�@�C���̃C���N���[�h
#include <windows.h>	// �W��WindowsAPI
#include <stdio.h>		// C�W�����o��
#include <string.h>		// C�����񏈗�

// main�֐��̒�`
int main(int argc, TCHAR *argv[]){	// main�֐�

	// �ϐ��̐錾.
	HANDLE hHeap;	// �q�[�v�n���h��hHeap
	LPSTR lpszText;	// ������|�C���^lpszText

	// ���̃v���Z�X�̃q�[�v���擾.
	hHeap = GetProcessHeap();	// GetProcessHeap�ł��̃v���Z�X�̃q�[�v�n���h�����擾.

	// �������m��.
	lpszText = (LPSTR)HeapAlloc(hHeap, HEAP_ZERO_MEMORY, 16);	// HeapAlloc�ŃT�C�Y16�̃��������m�ۂ�, ���̃������̃|�C���^��Ԃ�.(LPVOID�Ȃ̂�LPSTR�ɃL���X�g����lpszText�Ɋi�[.)

	// ��������m�ۂ����������ɃR�s�[.
	strcpy(lpszText, "ABCDE");	// strcpy��lpszText��"ABCDE"���R�s�[.

	// ������̏o��.
	printf("lpszText(hHeap) = %s\n", lpszText);	// printf��lpszText���o��.

	// ���������.
	HeapFree(hHeap, NULL, lpszText);	// HeapFree��lpszText�̃����������.

	// �v���O�����̏I��.
	return 0;

}